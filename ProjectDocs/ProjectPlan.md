# <div align="center">GROUP 10 PROJECT PLAN</div>
## <div align="center">This is a living (evergreen) document</div>


## GROUP 10 COMP2003 HK TREE WATCH 

ROLES
- [x] Leo (Techicanl Lead, Version Control)
- [x] Simon (Scrum Master , Coach)
- [x] Rishi (Product owner, features, backlog)
- [x] Client [NGO]

### PROJECT VISION
To realize our client's goals in developing and implementing a Natural science survey system with a primary focus on the surveying and data retrieval of tree species. This new system aims to replace the current antiquated paper-based recording and the problems that arise with manual data entry. 

Our vision is to enable key stakeholders, namely, researchers and the general public, a sense of pride and love of nature surrounding Hong Kong's diverse flora.

### LIST OF NON TECHNICAL OBJECTIVES
- Ensure the delivery of a high-quality system within the project scope.
- To create productivity gains over the current paper-based implementation.
- Create secure & privacy-compliant software that meets local regulatory and ethical standards.
- Create a visually compelling, high learnability interface based on client feedback
- To increase adoption and usage of the software through gamification.

## SOFTWARE REQUIREMENTS & SCOPE

### PRODUCT SCOPE
- Provide a comprehensive & consistent method for both beginner and advanced surveyors to record and retrieve tree species data by oberveration and assess changes associated with particular species over time.

### PRODUCT VALUE ( How the audience will find value )
- Provide a knowledge base on the local trees and diverse fauna in Hong Kong
- Gamification to encourage repeat usage
- Safety and Protection for the general public against damaged or dangerous trees or trees with root damage.
- Replace old paper system, increase speed efficiency, retrieval

###  Intended Audience (Who the product is intended to serve)
- General Public (Ametuer surveyors)
- Professional surveyors
- Administrators (are admins also surveyors?)


## INTENDED USE
- Mobile users on hikes, walks, one-handed input  of data on the spot during real-time observation
- On the desktop at home, upload data in a more casual environment with saved photos

## FUNCTIONAL REQUIRMENTS & FEATURES
- Server & Client Component to collect & process data
- Database Management System for data storage & retrieval
- Support multiple devices, laptops, desktops, and mobile phones
- Already have a predefined demo species list 
- Allow users to input and record information 
- Attached multimedia, videos, images
- Authentication system
- Search & filter features
- Users should be able to edit and remove their own surveys, but admins have full control
- Keep a log of all entries with timestamps
- Admins have full CRUD operation
- Views include List & Grid view, sorting, filtering, thumbnails, maps.
- Exporting data to different formats
- Gamification to encourage users to upload data. (Badge Service)
- Secure

## CONSTRAINTS
- Focus on Trees at this moment with the possibility to expand the scope to other species, i.e. birds and trees in the future.
- PWA Limitations (Browser API's may not be fully supported, but they do offer 90% of requirements) And we feel this is the way forward to increse adoption rather then being in the app store which is often difficult to find.
- Apple IOS does support PWA, but it does have some limitations on its support; users can always fall back to the website.


## USER INTERFACE REQUIREMENTS
- Responsive application
- Progress WEB Application 
-  We will constantly iterate after several rounds of usability testing and feedback
- Follow common design principles such as Visibility, Feeback, Constraints, Consistency & Affordance (Interaction Design, SHARP, 2019). This will help our application have a good user experience, 
 For example 
(Feedback) Give the user feedback or error notifications for incorrect validations or failed inputs. 
(Constrains) specific features for different types of user roles may be hidden or dimmed.
(Visibility) by making it clear to the user what to do next and where to click.


## HARDWARE REQUIREMENTS
- Mobile Phone
- Tablet
- Desktop or Laptop Computer
- Wired / Wireless / Mobile internet connection


## COMMUNICATION INTERFACE REQUIREMENTS 
- Email notifications?
- SMS notifications?

## CONTEXT OF USE
- As a layperson, Marie visits HK TREE WATCH. She hears about it on social media. The web-based mobile app detects her location with her approval and she is shown a gallery of unique trees around her home address. She is surprised as she has never seen these beautiful trees before! Marie decides to go outside to see if she can capture an image and upload it to HKTree Watch
- Frank is a professional surveyor and is a member of HK Tree Watch. He is authorized to moderate users surveys. Frank logs in and sees that some pending surveys need to be approved. He uses his desktop device to manage these surveys. A survey from Marie needs to be approved. Frank reviews the survey and finds some missing details, such as the tree tags. Frank updates the survey with the correct information and approves the survey.
- Tina is the Administrator, she needs to manage some users. From her office laptop she logs in to HK TREE WATCH  and clicks on the users profile. She sees a master list of users, which includes all regular users,  She clicks on "Create new user" and adds a new Adminstroar role. Tina can now rely on the additional help to maintain the software.
- As a normal user, Jenny would like to export her data for a school project. She logs in to her account from her mobile phone and sees her dashboard filled with 20 approved surveys. She clicks on the export button and can download her file. She then opens the file on her laptop and can manipulate the data further.
- Paul is a Moderator, he wants to update a record that was previously made incorrectly. When he visits the tree he creates a new survey and inputs all the data; suddenly, his 4G network loses connectivity; however, the application is still able to store all user input. Paul is aware that the network has disconnected but the app is stable. After he finishes updating the record, he clicks "Save"  The app saves the record to his device, and when connected back to the internet, the app is able to communicate with the server to save his data. There was no data loss!

## USER STORY
![USER STORY](https://github.com/hkuspace-pu/project-submission-group-10-HKNatureWatch/blob/c02a0ee0fea9570e868184a29da3c9d08487cd33/ProjectDocs/group%20project%20prouct%20plan%20user%20story.jpg)

## RISK MANAGAMENT PLAN

### BUDGET RISK
  - Given that this is a project for an NGO with a minimal budget, we are mandated to keep our costs as low as possible while delivering a high-quality product. Thus a heavy reliance on team cooperation and work ethic are of utmost importance while keeping the budget low.

**SOLUTION**
   - Using open source software and off-the-shelf products to design and implement the software without a burdening expense.

### SCOPE CREEP
  - Scope creep is a phenomenon of the software development lifecycle; it happens when the client adds features that were not already discussed at the planning stage, thus increasing the cost and workload for our team and may push deadlines beyond the time limit set.

**SOLUTION**
  - Regular client meetings are necessary to ensure that plans are followed strictly to avoid scope creep. All stakeholders must be in agreement to the product backlog and the features that are required. Small and trivial additional features are usually acceptable.

### TIME CONSTRAINTS
  - Deadlines are often difficult to stick to due to the very nature of the software development lifecycle. Improper time management and lack of talent are several factors that can push deadlines and affect the completion of work.

**SOLUTION**
 - By using agile methodologies and sticking to deadlines for software releases as well as keeping a time buffer should alleviate most of the time delays that we may experien
  
### EXTERNAL FACTORS
  - Face-to-face client meetings may be hindered due to the current Covid-19 pandemic and the restrictions that are still present in Hong Kong. While some of the restrictions have been lifted, they have yet to be totally removed.

**SOLUTION**
  - Channels of communication such as Slack, Zoom will be utilized if incase such face-to-face meetings cannot take place, although meeting clients face to face is a preferred choice to obtain valuable feedback.    
    
### SECURITY ATTACK

  - There may have IP attack, data tamper or sql injection hacking by the hacker that harm the application.

**SOLUTION**

  - We can set up the network VPC for the service group, using firewall and WAF, using HTTPS instead of HTTP. Adding verification for the API requests.

## COMMUNICATION PLAN - 
Teammates
We use WhatsApp, google drive, git, Teamgantt, and face-to-face meetings to communicate with teammates
Teamgantt is our schedule. We mark down, what we are going to do and how long we prepare.
We will submit our working in here. And Git can make a task or command.
Whatsapp is the main communication. But we do not talk about any sensitive information. We will note teammates, whether we made changes somewhere or what we did. Our documents will store in google drive.

Client
We communicate client by using email and meeting.


## UML - TO BE COMPLETED

## SPRINT PLAN - TO BE COMPLETED
...


## QUESTIONS FOR CLIENT
- Does the client have any specific requests on the layout?
- Any other questions
- Any other core features missing or required that are within the scope of the project?
- Client Communication - Weekly meetings and communication over channels like slack and email & zoom?



