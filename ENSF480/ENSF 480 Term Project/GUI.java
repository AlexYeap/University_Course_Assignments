import javax.swing.*;

import com.formdev.flatlaf.FlatDarkLaf;
import java.awt.event.*;
import java.util.ArrayList;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import java.awt.Color;
import java.awt.Dimension;

public class GUI implements ActionListener, ItemListener {
    String movieChosen = "";
    Movie movie = new Movie();
    ArrayList<Movie> movies = new ArrayList<>();
    String theatreChosen = "";
    Theatre theatre = new Theatre();
    ArrayList<Theatre> theatersList = new ArrayList<>();
    String roomName = "";
    Showroom showroom;
    ArrayList<Showroom> showRooms = new ArrayList<>();
    String seatNumber = "";

    String dateChosen = "";
    ShowTime showtime = new ShowTime();
    String timeofday = "";

    String time = "";

    Ticket ticket = new Ticket();
    String emailForRefund = "";

    boolean isAuthenticated = false;
    RegisteredUser regUser;
    Account account = new Account();

    public GUI()
    {
        try 
        {
            UIManager.setLookAndFeel(new FlatDarkLaf());
        } 
        catch (UnsupportedLookAndFeelException e1) 
        {
            e1.printStackTrace();
        }

        JFrame frame = new JFrame();

        startupPanel(frame);
    }

    public static void main(String[] args)
    {
        new GUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
    
    private void startupPanel(JFrame frame)
    {
        frame.getContentPane().removeAll();

        JPanel startPanel = new JPanel();
        startPanel.setLayout(new BorderLayout());

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        JButton guestButton = new JButton("Start as Guest");
        guestButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                guestPanel(frame);
            }
        });

        JButton userButton = new JButton("Start as Registered User");
        userButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                userPanel(frame);
            }
        });

        buttonPanel.add(guestButton);
        buttonPanel.add(userButton);
        startPanel.add(buttonPanel, BorderLayout.SOUTH);
        startPanel.add(new JLabel("Ticket Reservation App", SwingConstants.CENTER), BorderLayout.CENTER);

        frame.getContentPane().add(startPanel);
        frame.setSize(900, 500);
        frame.setVisible(true);
    }

    private void guestPanel(JFrame frame)
    {
        frame.getContentPane().removeAll();

        JPanel guestPanel = new JPanel();
        guestPanel.setLayout(new BorderLayout());

        JPanel backButtonPanel = new JPanel();
        backButtonPanel.setLayout(new FlowLayout());

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, 1));

        JPanel buttonPanelButtons = new JPanel();
        buttonPanelButtons.setLayout(new FlowLayout());

        JPanel buttonPanelText = new JPanel();
        buttonPanelButtons.setLayout(new FlowLayout());

        JButton backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                startupPanel(frame);
            }
        });
        JButton TheatreButton = new JButton("Browse Theatres");
        TheatreButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                theatrePanel(frame , 1,0);
            }
        });
        JButton movieButton = new JButton("Browse Movies");
        movieButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                moviePanel(frame,0,0);
            }
        });

        JButton refundButton = new JButton("Refund a Ticket");
        refundButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                refundPanel(frame,0);
            }
        });

        backButtonPanel.add(backButton);

        buttonPanelButtons.add(movieButton);
        buttonPanelButtons.add(refundButton);
        buttonPanelButtons.add(TheatreButton);


        buttonPanelText.add(new JLabel("What would you like to do today?"));

        buttonPanel.add(buttonPanelText);
        buttonPanel.add(buttonPanelButtons);

        guestPanel.add(backButtonPanel, BorderLayout.WEST);
        guestPanel.add(buttonPanel, BorderLayout.SOUTH);

        frame.getContentPane().add(guestPanel);
        frame.setVisible(true);
    }

    private void userPanel(JFrame frame)
    {
        frame.getContentPane().removeAll();

        JPanel userPanel = new JPanel();
        userPanel.setLayout(new BorderLayout());

        JPanel backButtonPanel = new JPanel();
        backButtonPanel.setLayout(new FlowLayout());

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, 1));

        JPanel buttonPanelButtons = new JPanel();
        buttonPanelButtons.setLayout(new FlowLayout());

        JPanel buttonPanelText = new JPanel();
        buttonPanelButtons.setLayout(new FlowLayout());

        JButton backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                startupPanel(frame);
            }
        });

        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                loginPanel(frame);
            }
        });

        JButton registerButton = new JButton("Register");
        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                RegisterPanel(frame);
            }
        });

        backButtonPanel.add(backButton);

        buttonPanelButtons.add(loginButton);
        buttonPanelButtons.add(registerButton);

        buttonPanelText.add(new JLabel("What would you like to do today?"));

        buttonPanel.add(buttonPanelText);
        buttonPanel.add(buttonPanelButtons);

        userPanel.add(backButtonPanel, BorderLayout.WEST);
        userPanel.add(buttonPanel, BorderLayout.SOUTH);

        frame.getContentPane().add(userPanel);
        frame.setVisible(true);
    }

    private void RegisterPanel(JFrame frame) 
    {
        frame.getContentPane().removeAll();

        JPanel registerPanel = new JPanel();
        registerPanel.setLayout(new BorderLayout());

        JPanel backButtonPanel = new JPanel();
        backButtonPanel.setLayout(new FlowLayout());

        JPanel submitPanel = new JPanel();
        submitPanel.setLayout(new FlowLayout());

        JPanel textPanel = new JPanel();
        textPanel.setLayout(new FlowLayout());

        JPanel fieldsPanel = new JPanel();
        fieldsPanel.setLayout(new BoxLayout(fieldsPanel, 1));

        JPanel firstNamePanel = new JPanel();
        firstNamePanel.setLayout(new BoxLayout(firstNamePanel, 0));

        JPanel lastNamePanel = new JPanel();
        lastNamePanel.setLayout(new BoxLayout(lastNamePanel, 0));

        JPanel addressPanel = new JPanel();
        addressPanel.setLayout(new BoxLayout(addressPanel, 0));

        JPanel paymentCardPanel = new JPanel();
        paymentCardPanel.setLayout(new BoxLayout(paymentCardPanel, 0));

        JPanel emailPanel = new JPanel();
        emailPanel.setLayout(new BoxLayout(emailPanel, 0));

        JPanel passwordPanel = new JPanel();
        passwordPanel.setLayout(new BoxLayout(passwordPanel, 0));

        JButton backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                userPanel(frame);
            }
        });

        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                    ManageData manageData = new ManageData();
                    manageData.registerUser(account);
                    regUser = new RegisteredUser(account);
                    registeredUserPanel(frame);   
            }
        });

        JTextField firstNameField = new JTextField();
        firstNameField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                account.setFname(firstNameField.getText());
            }
        });

        JTextField lastNameField = new JTextField();
        lastNameField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                account.setLname(lastNameField.getText());
            }
        });

        JTextField addressField = new JTextField();
        addressField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                account.setAddress(addressField.getText());
            }
        });

        JTextField paymentCardField = new JTextField();
        paymentCardField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                account.setPayment(paymentCardField.getText());
            }
        });

        JTextField emailField = new JTextField();
        emailField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                account.setEmail(emailField.getText());
            }
        });

        JPasswordField passwordField = new JPasswordField();
        passwordField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                account.setPassword(passwordField.getPassword());
            }
        });

        submitPanel.add(submitButton);

        textPanel.add(new JLabel("Please Enter your Information Below to Register"));
        firstNamePanel.add(new JLabel("First Name: "));
        firstNamePanel.add(firstNameField);

        lastNamePanel.add(new JLabel("Last Name: "));
        lastNamePanel.add(lastNameField);

        addressPanel.add(new JLabel("Address: "));
        addressPanel.add(addressField);

        paymentCardPanel.add(new JLabel("Payment Card: "));
        paymentCardPanel.add(paymentCardField);

        emailPanel.add(new JLabel("Email: "));
        emailPanel.add(emailField);

        passwordPanel.add(new JLabel("Password: "));
        passwordPanel.add(passwordField);

        fieldsPanel.add(textPanel);
        fieldsPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        fieldsPanel.add(firstNamePanel);
        fieldsPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        fieldsPanel.add(lastNamePanel);
        fieldsPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        fieldsPanel.add(addressPanel);
        fieldsPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        fieldsPanel.add(paymentCardPanel);
        fieldsPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        fieldsPanel.add(emailPanel);
        fieldsPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        fieldsPanel.add(passwordPanel);
        fieldsPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        fieldsPanel.add(submitPanel);

        backButtonPanel.add(backButton);

        registerPanel.add(backButtonPanel, BorderLayout.WEST);
        registerPanel.add(fieldsPanel, BorderLayout.SOUTH);

        frame.getContentPane().add(registerPanel);
        frame.setVisible(true);
    }

    private void loginPanel(JFrame frame) 
    {
        frame.getContentPane().removeAll();

        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(new BorderLayout());

        JPanel backButtonPanel = new JPanel();
        backButtonPanel.setLayout(new FlowLayout());

        JPanel submitPanel = new JPanel();
        submitPanel.setLayout(new FlowLayout());

        JPanel textPanel = new JPanel();
        textPanel.setLayout(new FlowLayout());

        JPanel fieldsPanel = new JPanel();
        fieldsPanel.setLayout(new BoxLayout(fieldsPanel, 1));

        JPanel userPanel = new JPanel();
        userPanel.setLayout(new BoxLayout(userPanel, 0));

        JPanel passwordPanel = new JPanel();
        passwordPanel.setLayout(new BoxLayout(passwordPanel, 0));

        JButton backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                userPanel(frame);
            }
        });

        JTextField userField = new JTextField();
        userField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                account.setEmail(userField.getText());
            }
        });

        JPasswordField passwordField = new JPasswordField();
        passwordField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                account.setPassword(passwordField.getPassword());
            }
        });

        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                    ManageData managetData = new ManageData();
                    
                    if(managetData.validateLogin(account.getEmail(), account.getPassword())){
                        account = managetData.getAccount(account.getEmail());
                        regUser = new RegisteredUser(account);
                        registeredUserPanel(frame); 
                    }
                    else{
                        JFrame popup = new JFrame();
                        JPanel temp = new JPanel();
                        JLabel text = new JLabel("Invalid email/password", SwingConstants.CENTER);
                        text.setForeground(Color.RED);
                        temp.setLayout(new FlowLayout());
                        temp.add(text);
                        popup.add(temp);
                        popup.setSize(200, 100);
                        popup.setVisible(true);
                    }
            }
        });


        submitPanel.add(submitButton);

        textPanel.add(new JLabel("Please Enter your Email and Password to Login"));

        userPanel.add(new JLabel("Email: "));
        userPanel.add(userField);

        passwordPanel.add(new JLabel("Password: "));
        passwordPanel.add(passwordField);

        fieldsPanel.add(textPanel);
        fieldsPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        fieldsPanel.add(userPanel);
        fieldsPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        fieldsPanel.add(passwordPanel);
        fieldsPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        fieldsPanel.add(submitPanel);

        backButtonPanel.add(backButton);

        loginPanel.add(backButtonPanel, BorderLayout.WEST);
        loginPanel.add(fieldsPanel, BorderLayout.SOUTH);

        frame.getContentPane().add(loginPanel);
        frame.setVisible(true);
    }

    private void moviePanel(JFrame frame, int i, int j)
    {
        frame.getContentPane().removeAll();

        JPanel moviePanel = new JPanel();
        moviePanel.setLayout(new BorderLayout());

        JPanel backButtonPanel = new JPanel();
        backButtonPanel.setLayout(new FlowLayout());

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, 1));

        JPanel buttonPanelText = new JPanel();
        buttonPanelText.setLayout(new FlowLayout());

        JPanel submitButtonPanel = new JPanel();
        submitButtonPanel.setLayout(new FlowLayout());

        JButton backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(i == 0 && j == 1 ){
                    registeredUserPanel(frame);
                }
                else if(i == 0 && j ==0){
                    guestPanel(frame);
                }
                else{
                    theatrePanel(frame, i,j);
                }
            }
        });

        ManageData manageDate = new ManageData();

        if(i == 0){
            movies = manageDate.getMovies();
        }
        else{
            movies = theatre.getMovies();
        }
        
        JPanel[] moviesPanel = new JPanel[movies.size()];
        for (int k = 0; k < moviesPanel.length; k++) {
            moviesPanel[k] = new JPanel();
            moviesPanel[k].setLayout(new FlowLayout());
        }
        JButton[] moviesButton = new JButton[movies.size()];
        for (int k = 0; k < moviesButton.length; k++) {
            //This needs more implementation later. Database connection for seats and if allowing more seats then 1
            moviesButton[k] = new JButton(movies.get(k).getMovieName());
            moviesButton[k].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    movieChosen = ((JButton) e.getSource()).getText();
                    for(Movie movieInList: movies){
                        if(movieChosen.equalsIgnoreCase(movieInList.getMovieName())){
                            movie = movieInList;
                        }
                    }
                    ((JButton) e.getSource()).setForeground(Color.RED);
                }
            });
            moviesPanel[k / movies.size()].add(moviesButton[k]);
        }

        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (i == 0){
                    theatrePanel(frame,i,j);
                }
                else if(i == 1){
                    showroomPanel(frame, i,j);
                }
 
            }
        });

        backButtonPanel.add(backButton);

        submitButtonPanel.add(submitButton);

        buttonPanelText.add(new JLabel("Please Select the Movie you'd like to Watch"));

        buttonPanel.add(buttonPanelText);
        for (JPanel s : moviesPanel) {
            buttonPanel.add(s);
        }
        buttonPanel.add(submitButtonPanel);

        moviePanel.add(backButtonPanel, BorderLayout.WEST);
        moviePanel.add(buttonPanel, BorderLayout.SOUTH);


        frame.getContentPane().add(moviePanel);
        frame.setVisible(true);
    }

    private void theatrePanel(JFrame frame, int i, int j) {
        frame.getContentPane().removeAll();

        JPanel theatrePanel = new JPanel();
        theatrePanel.setLayout(new BorderLayout());

        JPanel backButtonPanel = new JPanel();
        backButtonPanel.setLayout(new FlowLayout());

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, 1));

        JPanel buttonPanelText = new JPanel();
        buttonPanelText.setLayout(new FlowLayout());

        JPanel submitButtonPanel = new JPanel();
        submitButtonPanel.setLayout(new FlowLayout());

        JButton backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (i == 1 && j == 1) {
                    registeredUserPanel(frame);
                } else if (i == 1 && j == 0) {
                    guestPanel(frame);
                } else if (i == 0) {
                    moviePanel(frame, i, j);
                }

            }
        });

        ManageData manageData = new ManageData();

        if (i == 0) {
            theatersList = manageData.getTheatersForMovie(movieChosen);
        } else {
            theatersList = manageData.getTheaters();
        }

        JPanel[] theatresPanel = new JPanel[theatersList.size()];
        for (int k = 0; k < theatresPanel.length; k++) {
            theatresPanel[k] = new JPanel();
            theatresPanel[k].setLayout(new FlowLayout());
        }
        JButton[] theatres = new JButton[theatersList.size()];

        for (int k = 0; k < theatres.length; k++) {
            theatres[k] = new JButton(theatersList.get(k).getTheaterName());
            theatres[k].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    theatreChosen = ((JButton) e.getSource()).getText();
                    for (Theatre theater : theatersList) {
                        if (theatreChosen.equalsIgnoreCase(theater.getTheaterName())) {
                            theatre = theater;
                        }
                    }
                    ((JButton) e.getSource()).setForeground(Color.RED);
                }
            });
            theatresPanel[k / theatersList.size()].add(theatres[k]);
        }

        JButton submitButton = new JButton("Submit");

        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (i == 0) {
                    //System.out.println(theatre);
                    showroomPanel(frame, i, j);
                } else if (i == 1) {
                    System.out.println(theatre.getTheaterName());
                    moviePanel(frame, i, j);
                }
            }
        });

        backButtonPanel.add(backButton);
        submitButtonPanel.add(submitButton);
        buttonPanelText.add(new JLabel("Please Choose a theatre", SwingConstants.CENTER));
        buttonPanel.add(buttonPanelText);
        for (JPanel s : theatresPanel) {
            buttonPanel.add(s);
        }

        buttonPanel.add(submitButtonPanel);

        theatrePanel.add(backButtonPanel, BorderLayout.WEST);
        theatrePanel.add(buttonPanel, BorderLayout.SOUTH);

        frame.getContentPane().add(theatrePanel);
        frame.setVisible(true);
    }
    
    private void timePanel(JFrame frame, int i,int j) {
        frame.getContentPane().removeAll();

        JPanel timePanel = new JPanel();
        timePanel.setLayout(new BorderLayout());

        JPanel backButtonPanel = new JPanel();
        backButtonPanel.setLayout(new FlowLayout());

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, 1));

        JPanel buttonPanelText = new JPanel();
        buttonPanelText.setLayout(new FlowLayout());

        JPanel submitButtonPanel = new JPanel();
        submitButtonPanel.setLayout(new FlowLayout());

        JButton backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showroomPanel(frame, i,j);
            }
        });

        JPanel[] timesPanel = new JPanel[showroom.getShowTimes().size()];
        for (int k = 0; k < timesPanel.length; k++) {
            timesPanel[k] = new JPanel();
            timesPanel[k].setLayout(new FlowLayout());
        }
        
        JButton[] showtimes = new JButton[showroom.getShowTimes().size()];

        for(int k = 0; k < showroom.getShowTimes().size(); k++)
        {
            showtimes[k] = new JButton(showroom.getShowTimes().get(k).getDateOfShow());
            showtimes[k].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    ((JButton) e.getSource()).setForeground(Color.RED);
                    dateChosen = ((JButton) e.getSource()).getText();
                    for (ShowTime time : showroom.getShowTimes()) {
                        if (dateChosen.equalsIgnoreCase(time.getDateOfShow())) {
                            showtime = time;
                        }
                    }
                }
            });
            buttonPanel.add(showtimes[k]);
        }

        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Add functionality depending on what the ComboBox is
                System.out.println(time);
                timeofdayPanel(frame, i,j);
            }
        });

        backButtonPanel.add(backButton);

        submitButtonPanel.add(submitButton);

        buttonPanelText.add(new JLabel("Please Select a Available Showtime"));

        buttonPanel.add(buttonPanelText);
        buttonPanel.add(submitButtonPanel);

        timePanel.add(backButtonPanel, BorderLayout.WEST);
        timePanel.add(buttonPanel, BorderLayout.SOUTH);

        frame.getContentPane().add(timePanel);
        frame.setVisible(true);
    }

    private void timeofdayPanel(JFrame frame, int i,int j) {
        frame.getContentPane().removeAll();

        JPanel timePanel = new JPanel();
        timePanel.setLayout(new BorderLayout());

        JPanel backButtonPanel = new JPanel();
        backButtonPanel.setLayout(new FlowLayout());

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, 1));

        JPanel buttonPanelText = new JPanel();
        buttonPanelText.setLayout(new FlowLayout());

        JPanel submitButtonPanel = new JPanel();
        submitButtonPanel.setLayout(new FlowLayout());

        JButton backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                timePanel(frame, i,j);
            }
        });
        
        JButton[] showtimes = new JButton[showtime.getTimeOfShow().length];

        for(int k = 0; k < showtime.getTimeOfShow().length; k++)
        {
            showtimes[k] = new JButton(showtime.getTimeOfShow()[k]);
            showtimes[k].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    ((JButton) e.getSource()).setForeground(Color.RED);
                    timeofday = ((JButton) e.getSource()).getText();
                }
            });
            buttonPanel.add(showtimes[k]);
        }

        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Add functionality depending on what the ComboBox is
                System.out.println(time);
                seatPanel(frame, i,j);
            }
        });

        backButtonPanel.add(backButton);

        submitButtonPanel.add(submitButton);

        buttonPanelText.add(new JLabel("Please Select a Available Showtime"));

        buttonPanel.add(buttonPanelText);
        buttonPanel.add(submitButtonPanel);

        timePanel.add(backButtonPanel, BorderLayout.WEST);
        timePanel.add(buttonPanel, BorderLayout.SOUTH);

        frame.getContentPane().add(timePanel);
        frame.setVisible(true);
    }

    private void seatPanel(JFrame frame, int i, int j)
    {
        frame.getContentPane().removeAll();

        JPanel seatPanel = new JPanel();
        seatPanel.setLayout(new BorderLayout());

        JPanel backButtonPanel = new JPanel();
        backButtonPanel.setLayout(new FlowLayout());

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, 1));

        JPanel buttonPanelText = new JPanel();
        buttonPanelText.setLayout(new FlowLayout());

        JPanel submitButtonPanel = new JPanel();
        submitButtonPanel.setLayout(new FlowLayout());

        JPanel[] seatsPanel = new JPanel[showroom.getSeats().size()];

        for (int k = 0; k < seatsPanel.length; k++) {
            seatsPanel[k] = new JPanel();
            seatsPanel[k].setLayout(new FlowLayout());
        }

        JButton backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                timePanel(frame,i,j);
            }
        });

        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                paymentPanel(frame,i, j);
            }
        });

        JButton[] seats = new JButton[showroom.getSeats().size()];

        for (int k = 0; k < seats.length; k++) {
            seats[k] = new JButton(showroom.getSeats().get(k).getSeatNumber());
            seats[k].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    System.out.println(((JButton) e.getSource()).getText());
                    ((JButton) e.getSource()).setForeground(Color.RED);
                }
            });
            seatsPanel[k % 5].add(seats[k]);
        }

        backButtonPanel.add(backButton);

        submitButtonPanel.add(submitButton);

        buttonPanelText.add(new JLabel("Please Choose a Seat", SwingConstants.CENTER));

        buttonPanel.add(buttonPanelText);

        for (JPanel s : seatsPanel) {
            buttonPanel.add(s);
        }

        buttonPanel.add(submitButtonPanel);

        seatPanel.add(backButtonPanel, BorderLayout.WEST);
        seatPanel.add(buttonPanel, BorderLayout.SOUTH);

        frame.getContentPane().add(seatPanel);
        frame.setVisible(true);
    }

    private void showroomPanel(JFrame frame, int i, int j)
    {
        frame.getContentPane().removeAll();

        JPanel showroomPanel = new JPanel();
        showroomPanel.setLayout(new BorderLayout());

        JPanel backButtonPanel = new JPanel();
        backButtonPanel.setLayout(new FlowLayout());

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, 1));

        JPanel buttonPanelText = new JPanel();
        buttonPanelText.setLayout(new FlowLayout());

        JPanel submitButtonPanel = new JPanel();
        submitButtonPanel.setLayout(new FlowLayout());

        ManageData manageData = new ManageData();
        showRooms = manageData.getShowRooms(theatreChosen, movieChosen);

        JPanel[] showroomsPanel = new JPanel[showRooms.size()];

        for (int k = 0; k < showroomsPanel.length; k++) {
            showroomsPanel[k] = new JPanel();
            showroomsPanel[k].setLayout(new FlowLayout());
        }

        JButton backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(j == 0){
                    theatrePanel(frame,i,j);
                }
                else{
                    moviePanel(frame,i, j);
                }
            }
        });

        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                timePanel(frame,i, j);
            }
        });

        JButton[] showrooms = new JButton[showRooms.size()];

        for (int k = 0; k < showrooms.length; k++) {
            //This needs more implementation later. Database connection for seats and if allowing more seats then 1
            showrooms[k] = new JButton(showRooms.get(k).getRoomName());
            showrooms[k].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    roomName = ((JButton) e.getSource()).getText();
                    for(Showroom room: showRooms){
                        if(roomName.equalsIgnoreCase(room.getRoomName())){
                            showroom = room;
                        }
                    }
                    ((JButton) e.getSource()).setForeground(Color.RED);
                }
            });
            showroomsPanel[k / showRooms.size()].add(showrooms[k]);
        }

        backButtonPanel.add(backButton);

        submitButtonPanel.add(submitButton);

        buttonPanelText.add(new JLabel("Please Choose a Showroom", SwingConstants.CENTER));

        buttonPanel.add(buttonPanelText);

        for (JPanel s : showroomsPanel) {
            buttonPanel.add(s);
        }

        buttonPanel.add(submitButtonPanel);

        showroomPanel.add(backButtonPanel, BorderLayout.WEST);
        showroomPanel.add(buttonPanel, BorderLayout.SOUTH);

        frame.getContentPane().add(showroomPanel);
        frame.setVisible(true);
    }
    
    private void paymentPanel(JFrame frame, int i, int j)
    {
        frame.getContentPane().removeAll();

        JPanel paymentPanel = new JPanel();
        paymentPanel.setLayout(new BorderLayout());

        JPanel backButtonPanel = new JPanel();
        backButtonPanel.setLayout(new FlowLayout());

        JPanel textPanel = new JPanel();
        textPanel.setLayout(new FlowLayout());

        JPanel fieldsPanel = new JPanel();
        fieldsPanel.setLayout(new BoxLayout(fieldsPanel, 1));

        JPanel namePanel = new JPanel();
        namePanel.setLayout(new BoxLayout(namePanel, 0));

        JPanel emailPanel = new JPanel();
        emailPanel.setLayout(new BoxLayout(emailPanel, 0));

        JPanel addressPanel = new JPanel();
        addressPanel.setLayout(new BoxLayout(addressPanel, 0));

        JPanel localAddressPanel = new JPanel();
        localAddressPanel.setLayout(new BoxLayout(localAddressPanel, 0));

        JPanel countryPanel = new JPanel();
        countryPanel.setLayout(new BoxLayout(countryPanel, 0));

        JPanel creditNumberPanel = new JPanel();
        creditNumberPanel.setLayout(new BoxLayout(creditNumberPanel, 0));

        JPanel creditPanel = new JPanel();
        creditPanel.setLayout(new BoxLayout(creditPanel, 0));

        JPanel submitPanel = new JPanel();
        submitPanel.setLayout(new FlowLayout());

        JButton backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                    seatPanel(frame,i, j);
            }
        });

        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                completePanel(frame);
            }
        });

        JTextField firstNameField = new JTextField();
        firstNameField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        JTextField lastNameField = new JTextField();
        lastNameField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });

        JTextField emailField = new JTextField();
        emailField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });

        JTextField addressField = new JTextField();
        addressField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });

        JTextField cityField = new JTextField();
        cityField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        JTextField provinceField = new JTextField();
        provinceField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });

        JTextField countryField = new JTextField();
        countryField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });

        JTextField creditNumberField = new JTextField();
        creditNumberField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });

        JTextField creditExpireField = new JTextField();
        creditExpireField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        JTextField CVCField = new JTextField();
        CVCField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });

        textPanel.add(new JLabel("Please Enter you Information to Process Order"));

        namePanel.add(new JLabel("First Name: "));
        namePanel.add(firstNameField);
        namePanel.add(new JLabel(" Last Name: "));
        namePanel.add(lastNameField);

        emailPanel.add(new JLabel("Email: "));
        emailPanel.add(emailField);

        addressPanel.add(new JLabel("Street Address: "));
        addressPanel.add(addressField);

        localAddressPanel.add(new JLabel("City: "));
        localAddressPanel.add(cityField);
        localAddressPanel.add(new JLabel(" Province: "));
        localAddressPanel.add(provinceField);

        countryPanel.add(new JLabel("Country: "));
        countryPanel.add(countryField);

        creditNumberPanel.add(new JLabel("Credit Card Number: "));
        creditNumberPanel.add(creditNumberField);

        creditPanel.add(new JLabel("Exp. Date: "));
        creditPanel.add(creditExpireField);
        creditPanel.add(new JLabel(" CVC: "));
        creditPanel.add(CVCField);

        submitPanel.add(submitButton);

        fieldsPanel.add(textPanel);
        fieldsPanel.add(namePanel);
        fieldsPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        fieldsPanel.add(emailPanel);
        fieldsPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        fieldsPanel.add(addressPanel);
        fieldsPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        fieldsPanel.add(localAddressPanel);
        fieldsPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        fieldsPanel.add(countryPanel);
        fieldsPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        fieldsPanel.add(creditNumberPanel);
        fieldsPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        fieldsPanel.add(creditPanel);
        fieldsPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        fieldsPanel.add(submitPanel);

        backButtonPanel.add(backButton);
        paymentPanel.add(backButtonPanel, BorderLayout.WEST);
        paymentPanel.add(fieldsPanel, BorderLayout.SOUTH);

        frame.getContentPane().add(paymentPanel);
        frame.setVisible(true);
    }

    private void completePanel(JFrame frame)
    {
        frame.getContentPane().removeAll();

        JPanel completePanel = new JPanel();
        completePanel.setLayout(new BorderLayout());

        JButton mainMenuButton = new JButton("Return to Main Menu");
        mainMenuButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                startupPanel(frame);
            }
        });

        completePanel.add(new JLabel("Order / Refund Completed Succesfully", SwingConstants.CENTER),
                BorderLayout.CENTER);
        completePanel.add(mainMenuButton, BorderLayout.SOUTH);

        frame.getContentPane().add(completePanel);
        frame.setVisible(true);
    }
    
    private void refundPanel(JFrame frame, int i)
    {
        frame.getContentPane().removeAll();

        JPanel refundPanel = new JPanel();
        refundPanel.setLayout(new BorderLayout());

        JPanel backButtonPanel = new JPanel();
        backButtonPanel.setLayout(new FlowLayout());

        JPanel submitPanel = new JPanel();
        submitPanel.setLayout(new FlowLayout());

        JPanel textPanel = new JPanel();
        textPanel.setLayout(new FlowLayout());

        JPanel fieldsPanel = new JPanel();
        fieldsPanel.setLayout(new BoxLayout(fieldsPanel, 1));

        JPanel emailPanel = new JPanel();
        emailPanel.setLayout(new BoxLayout(emailPanel, 0));

        JPanel orderPanel = new JPanel();
        orderPanel.setLayout(new BoxLayout(orderPanel, 0));

        JButton backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (i == 0){
                guestPanel(frame);
                }
                else if(i == 1){
                registeredUserPanel(frame);
                }
            }
        });

        JTextField emailField = new JTextField();
        emailField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                emailForRefund = emailField.getText();
            }
        });

        JTextField orderField = new JTextField();
        orderField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ticket.setTicketID(Integer.parseInt(orderField.getText()));
            }
        });

        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ManageData manageData = new ManageData();
                if(manageData.validateTicket(ticket.getTicketID())){
                    manageData.removeTicket(ticket.getTicketID());
                    RefundReceipt reciept = new RefundReceipt();
                    reciept.createReciept(String.valueOf(ticket.getTicketID()), emailForRefund);
                    refundCompletePanel(frame);
                }
                else{
                    JFrame popup = new JFrame();
                    JPanel temp = new JPanel();
                    JLabel text = new JLabel("Invalid ticket number", SwingConstants.CENTER);
                    text.setForeground(Color.RED);
                    temp.setLayout(new FlowLayout());
                    temp.add(text);
                    popup.add(temp);
                    popup.setSize(200, 100);
                    popup.setVisible(true);
                }
            }
        });

        

        submitPanel.add(submitButton);

        textPanel.add(new JLabel("Please Enter your Email and Order Number to Refund your Ticket"));
        
        emailPanel.add(new JLabel("Email: "));
        emailPanel.add(emailField);

        orderPanel.add(new JLabel("Order Number: "));
        orderPanel.add(orderField);

        fieldsPanel.add(textPanel);
        fieldsPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        fieldsPanel.add(emailPanel);
        fieldsPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        fieldsPanel.add(orderPanel);
        fieldsPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        fieldsPanel.add(submitPanel);

        backButtonPanel.add(backButton);

        refundPanel.add(backButtonPanel, BorderLayout.WEST);
        refundPanel.add(fieldsPanel, BorderLayout.SOUTH);

        frame.getContentPane().add(refundPanel);
        frame.setVisible(true);
    }

    private void refundCompletePanel(JFrame frame)
    {
        frame.getContentPane().removeAll();

        JPanel refundcompletePanel = new JPanel();
        refundcompletePanel.setLayout(new BorderLayout());

        JButton mainMenuButton = new JButton("Return to Main Menu");
        mainMenuButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                startupPanel(frame);
            }
        });

        if(ticket.getforRegisteredUser() == 1){
            refundcompletePanel.add(new JLabel("Refund Completed Succesfully And No Administration Fee Was Charged", SwingConstants.CENTER),
                BorderLayout.CENTER);
        }
        else{
            refundcompletePanel.add(new JLabel("Refund Completed Succesfully and 15% administration fee was charged ", SwingConstants.CENTER),
                BorderLayout.CENTER);
        }
        
        refundcompletePanel.add(mainMenuButton, BorderLayout.SOUTH);

        frame.getContentPane().add(refundcompletePanel);
        frame.setVisible(true);
    }

    private void earlyMovieNewsPanel(JFrame frame)
    {
        frame.getContentPane().removeAll();

        JPanel earlyMovieNewsPanel = new JPanel();
        earlyMovieNewsPanel.setLayout(new BoxLayout(earlyMovieNewsPanel, 1));

        JPanel backButtonPanel = new JPanel();
        backButtonPanel.setLayout(new FlowLayout());

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, 1));

        JPanel buttonPanelText = new JPanel();
        buttonPanelText.setLayout(new FlowLayout());

        JButton backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                registeredUserPanel(frame);
            }
        });


        ManageData manageData = new ManageData();
        ArrayList<Movie> earlyMovieNews = manageData.getEarlyMovieNews();
        for(Movie movie: earlyMovieNews){
            earlyMovieNewsPanel.add(new JLabel(movie.getMovieName() + " will be released on " + movie.getReleaseDate() + " in " + movie.getTheaterName() + " theater"));
        }
        backButtonPanel.add(backButton);

        

        buttonPanel.add(buttonPanelText);

        earlyMovieNewsPanel.add(backButtonPanel, BorderLayout.WEST);
        earlyMovieNewsPanel.add(buttonPanel, BorderLayout.SOUTH);

        frame.getContentPane().add(earlyMovieNewsPanel);
        frame.setVisible(true);
    }

    private void feesPanel(JFrame frame)
    {
        frame.getContentPane().removeAll();

        JPanel feesPanel = new JPanel();
        feesPanel.setLayout(new BorderLayout());

        JPanel backButtonPanel = new JPanel();
        backButtonPanel.setLayout(new FlowLayout());

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, 1));

        JPanel buttonPanelText = new JPanel();
        buttonPanelText.setLayout(new FlowLayout());

        JButton backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                registeredUserPanel(frame);
            }
        });

        if (account.getFeesPaid() == 1)
        {
            buttonPanel.add(new JLabel("Fees already paid."));
        }
        else
        {
            JButton payButton = new JButton("Pay Fees with Card on file");
            payButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    regUser.payFee();
                    ManageData manageData = new ManageData();
                    manageData.updateFeesStatus(regUser.getAccount().getEmail());
                }
            });
            buttonPanel.add(payButton);
        }

        backButtonPanel.add(backButton);


        buttonPanel.add(buttonPanelText);

        feesPanel.add(backButtonPanel, BorderLayout.WEST);
        feesPanel.add(buttonPanel, BorderLayout.SOUTH);

        frame.getContentPane().add(feesPanel);
        frame.setVisible(true);
    }

    private void registeredUserPanel(JFrame frame)
    {
        frame.getContentPane().removeAll();

        JPanel registeredUserPanel = new JPanel();
        registeredUserPanel.setLayout(new BorderLayout());

        JPanel backButtonPanel = new JPanel();
        backButtonPanel.setLayout(new FlowLayout());

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, 1));

        JPanel buttonPanelButtons = new JPanel();
        buttonPanelButtons.setLayout(new FlowLayout());

        JPanel buttonPanelText = new JPanel();
        buttonPanelButtons.setLayout(new FlowLayout());

        JButton backButton = new JButton("Logout");
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                account = new Account();
                startupPanel(frame);
            }
        });
        JButton TheatreButton = new JButton("Browse Theatres");
        TheatreButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                theatrePanel(frame ,1,1);
            }
        });
        JButton movieButton = new JButton("Browse Movies");
        movieButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                moviePanel(frame,0,1);
            }
        });

        JButton refundButton = new JButton("Refund a Ticket");
        refundButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                refundPanel(frame,1);
            }
        });

        JButton payFeeButton = new JButton("Pay Annual fee");
        payFeeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                feesPanel(frame);
            }
        });

        JButton earlyMovieNewsButton = new JButton("Early Movie Announcements");
        earlyMovieNewsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                earlyMovieNewsPanel(frame);
            }
        });

        backButtonPanel.add(backButton);

        buttonPanelButtons.add(movieButton);
        buttonPanelButtons.add(refundButton);
        buttonPanelButtons.add(TheatreButton);
        buttonPanelButtons.add(earlyMovieNewsButton);
        buttonPanelButtons.add(payFeeButton);


        buttonPanelText.add(new JLabel("What would you like to do today?"));

        buttonPanel.add(buttonPanelText);
        buttonPanel.add(buttonPanelButtons);

        registeredUserPanel.add(backButtonPanel, BorderLayout.WEST);
        registeredUserPanel.add(buttonPanel, BorderLayout.SOUTH);

        frame.getContentPane().add(registeredUserPanel);
        frame.setVisible(true);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
    }
}
