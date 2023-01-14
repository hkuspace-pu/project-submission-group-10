# <div align="center">HK TREE WATCH (GROUP 10) PROJECT PLAN</div>
## <div align="center">Living document</div>


<!-- Table of Contents -->
# :notebook_with_decorative_cover: Table of Contents
- [Roles & Contribution](#busts_in_silhouette-roles) 
- [Product Vision](#star2-project-vision)
- [Non Technical Objectives](#dart-non-technical-objectives)
- [Software Requirements & Scope](#minidisc-software-requirments)
- [Product Value](#gift-product-value)
- [Initial Requirments - Intended Audience](#intended)
- [Initial Requirments - Context of use](#context)
- [Initial Requirments - User Storys](#userstory)
- [Features](#dart-features)
- [Constraints](#Constraints)
- [User Interface, Design Principles](#UI)
- [Hardware requirments](#hardware)
- [User Communcation](#user_comms)
- [Team Communication Plan](#team_comms)
- [Client Communication Plan](#client_comms)

- [Usability Study](#usability)
- [Risk Management](#risk)
- [Legal social ethical and professional issues](#legal-social-ethical-and-professional-issues)
- [OWASP](OWASP](#owasp)
- [UML Diagrams](#uml)
- [SPRINT PLANT](#sprint)
- [Furthur Questions](#questions)

<!--Roles-->
## :busts_in_silhouette: Roles
- [x] Leo (Techicanl Lead, Version Control) [Leo Xie @keixie838](https://github.com/leoxie838)
- [x] Simon (Scrum Master , Coach) [Ho Wing Simon @WSimonHo](https://github.com/WSimonHo)
- [x] Rishi (Product owner, features, backlog)  [Rishi Uttam - @ricky11](https://github.com/ricky11)

## :star2: Project Vision
To realize our client's goals in developing and implementing a Natural science survey system with a primary focus on the surveying and data retrieval of tree species. This new system aims to replace the current antiquated paper-based recording and the problems that arise with manual data entry. 

Our vision is to enable key stakeholders, namely, researchers and the general public, a sense of pride and love of nature surrounding Hong Kong's diverse flora.

## :dart: Non-Technical Objectives
- Ensure the delivery of a high-quality system within the project scope.
- To create productivity gains over the current paper-based implementation.
- Create secure & privacy-compliant software that meets local regulatory and ethical standards.
- Create a visually compelling, high learnability interface based on client feedback
- To increase adoption and usage of the software through gamification.

## :minidisc: Software Requirments

- Provide a comprehensive & consistent method for both beginner and advanced surveyors to record and retrieve tree species data by oberveration and assess changes associated with particular species over time, others points as per the functional requirments.

## :gift: Product Value
- Provide a knowledge base on the local trees and diverse fauna in Hong Kong
- Gamification to encourage repeat usage
- Safety and Protection for the general public against damaged or dangerous trees or trees with root damage.
- Replace old paper system, increase speed efficiency, retrieval

###  Intended Audience (Who the product is intended to serve)
- General Public (Ametuer surveyors)
- Professional surveyors
- Administrators (are admins also surveyors?)


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

### CONTEXT OF USE
- As a layperson, Marie visits HK TREE WATCH. She hears about it on social media. The web-based mobile app detects her location with her approval and she is shown a gallery of unique trees around her home address. She is surprised as she has never seen these beautiful trees before! Marie decides to go outside to see if she can capture an image and upload it to HKTree Watch
- Frank is a professional surveyor and is a member of HK Tree Watch. He is authorized to moderate users surveys. Frank logs in and sees that some pending surveys need to be approved. He uses his desktop device to manage these surveys. A survey from Marie needs to be approved. Frank reviews the survey and finds some missing details, such as the tree tags. Frank updates the survey with the correct information and approves the survey.
- Tina is the Administrator, she needs to manage some users. From her office laptop she logs in to HK TREE WATCH  and clicks on the users profile. She sees a master list of users, which includes all regular users,  She clicks on "Create new user" and adds a new Adminstroar role. Tina can now rely on the additional help to maintain the software.
- As a normal user, Jenny would like to export her data for a school project. She logs in to her account from her mobile phone and sees her dashboard filled with 20 approved surveys. She clicks on the export button and can download her file. She then opens the file on her laptop and can manipulate the data further.
- Paul is a Moderator, he wants to update a record that was previously made incorrectly. When he visits the tree he creates a new survey and inputs all the data; suddenly, his 4G network loses connectivity; however, the application is still able to store all user input. Paul is aware that the network has disconnected but the app is stable. After he finishes updating the record, he clicks "Save"  The app saves the record to his device, and when connected back to the internet, the app is able to communicate with the server to save his data. There was no data loss!
-  Mobile users on hikes, walks, one-handed input  of data on the spot during real-time observation
- On the desktop at home, upload data in a more casual environment with saved photos

## USER STORY
![USER STORY 1 & =2](https://github.com/hkuspace-pu/project-submission-group-10-HKNatureWatch/blob/main/ProjectDocs/user_story_1_2.jpg)
![USER_STORY 3](https://github.com/hkuspace-pu/project-submission-group-10-HKNatureWatch/blob/main/ProjectDocs/group%20project%20prouct%20plan%20user%20story%20(1).jpg)


##  USABILITY STUDY (QUICK AND DIRTY)
![Usability Study Image](https://github.com/hkuspace-pu/project-submission-group-10-HKNatureWatch/blob/main/ProjectDocs/usability_study/Usability%20Study%20Image.jpeg)
![Usability Study Image](https://github.com/hkuspace-pu/project-submission-group-10-HKNatureWatch/blob/main/ProjectDocs/usability_study/Usability%20Study%20Image2.jpeg)


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

## Legal social ethical and professional issues
Legal
- Compliance with local regulatory laws, Privacy Ordinance (PDPO) etc
- Does the client require is to disclouse the source code of the software, what is the Licence requirments?
- Follow regulations provided by Office of [Government Cheif Information Office]
- State our copyright law and trademark rules if any.
- Create a (AUP) Acceptable Use Policy
- (https://www.ogcio.gov.hk/en/our_work/community/web_mobileapp_accessibility/faq/)
- Hong Kong does not have GPDR but instead has [PDPO](https://www.hk-lawyer.org/content/eu-gdpr-and-hk-pdpo-what%E2%80%99s-difference)
- Terms and conditions and Terms of use (do we force users to use our app in a certain way?)
- Professional liability insurance for local jurisdiction.  


Ethical
- Define a code of ethics and a general code of conduct to be signed by all team members
- Ensure that users on the platform do not discrmenate, harrass other members, or post vulgar, violant information.
- Users must sign up with their real username; we want to prevent psudonames and do not want Trolls (i.e. twitter)
- Developers have the responsibility to protect user data.

Social
- Prevent online bullying on our forums or surveys or comments to other users.
- Prevent cultural dominance, i.e. no one race/cast of users can have power over another online on our website. Also English should not be the only laguage as it is the dominant one.
- Provide avenue of redress i.e. email, contact , telephone if one of our users is being harmed by another user on our platform

 



## COMMUNICATION PLAN - 
Teammates
We use WhatsApp, google drive, git, Teamgantt, and face-to-face meetings to communicate with teammates
Teamgantt is our schedule. We mark down, what we are going to do and how long we prepare.
We will submit our working in here. And Git can make a task or command.
Whatsapp is the main communication. But we do not talk about any sensitive information. We will note teammates, whether we made changes somewhere or what we did. Our documents will store in google drive.

## Client
- We communicate client by using email and regular meetings


## UML - TO BE COMPLETED

## Initial Sprint Action Plan 

![Sprint Action Plan](https://github.com/hkuspace-pu/project-submission-group-10-HKNatureWatch/blob/main/KanBan/sprint_screen.jpeg)


## QUESTIONS FOR CLIENT
- Does the client have any specific requests on the layout?
- Any other questions
- Any other core features missing or required that are within the scope of the project?
- Client Communication - Weekly meetings and communication over channels like slack and email & zoom?



