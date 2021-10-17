# SecurityIntegration
 
 ## Authors
  - **Youthan Irigoyen** - *App design, app functionality, database scripting and connectivity*
  - **Eduardo Rodríguez** - *Database scripting, networking and connectivity*
  - **Rebeca Rojas** - *Database modelling, networking and security*
  - **Fernanda Ramírez** - *Networking and app design*
  - **Jared Flores** - *Database modelling and networking*
  - **Diego Ulibarri** - *Project documenting and app design*
 
 ## Abstract
This project has been created for Dibujando Un Mañana, in order to support the institution by developing an app which connects it with people that would like to help by making donations to the different participating organizations. It has been made using mainly the Android Studio software with some external libraries that will be referred to in an upcoming document that covers the whole specifics of the app. This is a project that does not have any commercial interests as it is merely an academic practice that will be evaluated by the formerly mentioned organization.

## Main sections
 - **Organizations:** This section displays a list of the current participating insitutions. Once one of them is clicked, some information about it is displayed, as well as the option to make a donation by directly typing in the amount to be given. These payments do not go directly into any of our servers as the official PayPal API is being used to receive them, which makes it highly secure. (Currently the payments are made to a "sandbox" account that does not actually receive any kind of money).
 - **Events:** Institutions can register their respective events by simply adding some basic information about them. This events will be displayed in this section, and once one of them is clicked, information about it will be displayed to the user, allowing them to click the ***Participate*** button to add it to the events they've registered to.
 - **Projects:** Some instituions might have different projects which can also be added to our system and displayed to any user that is interested in participating in any of them. Once again, a list with the different existing projects will be shown, and any of them can be clicked to get it's information and register to it. 
 - **My profile:** This section is where the user can see the events and projects they've decided to participate in, as well as the donations they've made with specific information about the amount and date it was made. A ***Settings*** fragment might be added to the final version of the project. 
 
## How to use
### 1. Prerequisites:
 - Have ***Android Studio*** installed in your machine.
 - Have an ***AVD*** set within Android Studio to be able to run the project.
 - Have ***Node.js*** installed in your machine with the following libraries also installed:
``` 
npm install sequelize
``` 
 ``` 
npm install tedious
``` 
``` 
npm install bcrypt
``` 
``` 
npm install express
``` 
``` 
npm install body-parser
``` 
 - You might also want to install the ***nodemon*** plug-in to run the server right after saving your server without having to manually re-run it.
 - Have the ***SQL Services*** running in your machine, otherwise the server will not be able to connect to the localhost.
 - Optionally you might also want to download Microsoft's SQL Manager Service to visualize the project's database internally.
### 2. Installing the project:
To install the project simply clone it to your local machine or download the repository as a .zip file and extract it on an empty directory in order to let Android Studio recognize it as an Android project. (**Warning:** *Do not run the project if you have not completed the steps that follow*). 

### 3. Running the server's repository:
In order to be able to run the project's server you will need to clone the following repository in your local machine: ***https://github.com/joeirigoyen/SecIntServer***.

Once cloned, run the following command in the repository's directory:
```
npx nodemon
```
*If you do not have* ***nodemon*** *installed, just run the* ***index.js*** *file as you normally would in your terminal.*

### 4. Running the app:
 - Sign up using the information that the app needs in the ***Sign Up*** section.
 - Once you have an existing account, sign in using the credentials you used to register.
 - Feel free to explore the main interface. If you see that any of the previously listed sections are not displaying any info, your database might be empty. 
 
### 5. Adding info to the app:
Play with the app! Register with different types of accounts and create your own events and projects, then you'll see them displayed in their sections respectively.

## Contact
Should you need any further information regarding the app or some issues with the way the project's functioning, please contact any of the developers by one of the following means:

### Design issues: ###
  - ***Diego Ulibarri:*** a01636875@itesm.mx
### Bugs and general functionality issues: ###
  - ***Youthan Irigoyen:*** a01750476@itesm.mx
### Database and connectivity issues: ###
  - ***Eduardo Rodriguez:*** a01749381@itesm.mx

## Special thanks to:
 - **Yash Nagayach (https://www.youtube.com/channel/UCk44iYMGU9RSgpv8T6It7Sw)** - For teaching us more about how Retrofit works.
 - **Stevdza-San (https://github.com/stevdza-san/RetrofitDemo-Tutorial-Series)** - For explaining the use of MVVM with Retrofit perfectly.
 - **Hrishikesh Kadam & Ryan M on StackOverflow** - For providing fixes for most of our issues with the Android Studio platform.
