COMP2003HK

GROUP PROJECT (GROUP 10)

[Click here to view original Markdown on Github](https://github.com/hkuspace-pu/project-submission-group-10-HKNatureWatch/blob/f0ef2616be7570b262bec62ecc0c865f3bd4ad48/ProjectDocs/ProjectPlan.md)

<div align="center">

  <img src="/client/src/assets/images/tree.svg" alt="logo" width="200" height="auto" />
  <h1>HONG KONG NATURE WATCH</h1>
 <h3>PROJECT PLAN</h3>
  
  <p>
    A Natural Science Survey System for NGO client project
  </p>
 </div>
  
  
<!-- Badges -->
<p align="center">
  <a href="">
    <img src="https://badgen.net/badge/contributors/3/:color?icon=github" alt="contributors" />
  </a>
   <a href="">
    <img src="https://badgen.net/badge/build/passing/green" alt="contributors" />
  </a>
   <a href="">
    <img src="https://badgen.net/badge/npm/v3.2.45/blue" alt="contributors" />
  </a>

</p>
<div align="center">Living document</div>


<!-- Table of Contents -->
# :notebook_with_decorative_cover: Table of Contents
- [:busts_in_silhouette:  Roles & Contribution](#busts_in_silhouette-roles) 
- [:link:  Link To Offical Readme.md](#link-link-to-offical-readme) 
- [:star2:  Product Vision](#star2-project-vision)
- [:dart:  Project Objectives](#dart-project-objectives)
- [:minidisc:  Software Requirements & Scope](#minidisc-software-requirments)
- [:gift:  Product Value](#gift-product-value)
- [:busts_in_silhouette:  Initial Requirments Model - Intended Audience](#busts_in_silhouette-intended-audience)
- [:books:  Initial Requirments Model - User Story](#books-user-story)
- [:movie_camera:  Initial Requirments Model - Story Board](#movie_camera-story-board)
- [:straight_ruler:  Initial Requirments Model - UML for User Story Normal User Role](#straight_ruler-uml-user-story-diagram)
- [:raised_hands:  Boundaries for success](#raised_hands-boundaries-for-success)
- [:running:  Sprint Cadence](#running-sprint-cadence)
- [:eyes:  Features & Functional Requirements (High Level)](#eyes-features-and-functional-requirements)
- [:exclamation:  Constraints](#exclamation-constraints)
- [:earth_asia:  Product Roadmap & Release Plan Guideline](#earth_asia-product-roadmap-and-release-plan-guideline)
- [:art:  User Interface, Design Principles](#art-user-interface-and-design-principles)
- [:computer:  Hardware requirements](#computer-hardware-requirements)
- [:telephone:  Communication Plan](#telephone-communication-plan)
- [:minidisc:  Tech Stack](#minidisc-tech-stack)
- [:guardsman:  Usability Study](#guardsman-usability-study)
- [:traffic_light:  Risk Management Plan](#traffic_light-risk-management-plan )
- [:cop:  Legal social ethical and professional issues](#cop-legal-social-ethical-and-professional-issues)
- [:runner:  Sprint Plan](#runner-sprint-plan)
- Closer of issues Final
- Backlog Update
- [:runner:  Final Handover of project](#runner-sprint-plan)

<!--Roles-->
## :busts_in_silhouette: Roles
- [x] Leo (Technical Lead, Version Control) [Leo Xie @keixie838](https://github.com/leoxie838)
- [x] Simon (Scrum Master, Coach) [Ho Wing Simon @WSimonHo](https://github.com/WSimonHo)
- [x] Rishi (Product owner, features, backlog)  [Rishi Uttam - @ricky11](https://github.com/ricky11)

## :link: Link To Offical Readme
[Readme.md](https://github.com/hkuspace-pu/project-submission-group-10-HKNatureWatch/blob/main/Readme.md)

## :star2: Project Vision
To realize our client's goals in developing and implementing a Natural science survey system with a primary focus on the surveying and data retrieval of tree species. This new system aims to replace the current antiquated paper-based recording and the problems that arise with manual data entry. 

Our vision is to enable key stakeholders, namely, researchers and the general public, a sense of pride and love of nature surrounding Hong Kong's diverse flora.


## :dart: Project Objectives
- Ensure the delivery of a high-quality system within the project scope.
- To create productivity gains over the current paper-based implementation.
- Create secure & privacy-compliant software that meets local regulatory and ethical standards.
- Create a visually compelling, high-learnability interface based on client feedback
- To increase adoption and usage of the software through gamification.
- Meet all the functional requirements as per outlined in the product scope
-  Provide a comprehensive & consistent method for both beginner and advanced surveyors to record and retrieve tree species data by oberveration and assess changes associated with particular species over time, others points as per the functional requirments.

## :minidisc: Software Requirments

- This section is updated weekly; refer to [Readme.md](https://github.com/hkuspace-pu/project-submission-group-10-HKNatureWatch)

## :gift: Product Value
- Provide a knowledge base on the local trees and diverse fauna in Hong Kong
- Gamification to encourage repeat usage
- Safety and Protection for the general public against damaged or dangerous trees or trees with root damage.
- Replace old paper system, increase speed efficiency, retrieval

## :busts_in_silhouette: Intended Audience
- General Public (Ametuer surveyors)
- Professional surveyors
- Administrators
- Moderators

## :books: User Story
- As a layperson, Marie visits HK TREE WATCH. She hears about it on social media. The web-based mobile app detects her location with her approval and she is shown a gallery of unique trees around her home address. She is surprised as she has never seen these beautiful trees before! Marie decides to go outside to see if she can capture an image and upload it to HKTree Watch
- Frank is a professional surveyor and is a member of HK Tree Watch. He is authorized to moderate users surveys. Frank logs in and sees that some pending surveys need to be approved. He uses his desktop device to manage these surveys. A survey from Marie needs to be approved. Frank reviews the survey and finds some missing details, such as the tree tags. Frank updates the survey with the correct information and approves the survey.
- Tina is the Administrator, she needs to manage some users. From her office laptop she logs in to HK TREE WATCH  and clicks on the users profile. She sees a master list of users, which includes all regular users,  She clicks on "Create new user" and adds a new Adminstroar role. Tina can now rely on the additional help to maintain the software.
- As a normal user, Jenny would like to export her data for a school project. She logs in to her account from her mobile phone and sees her dashboard filled with 20 approved surveys. She clicks on the export button and can download her file. She then opens the file on her laptop and can manipulate the data further.
- Paul is a Moderator, he wants to update a record that was previously made incorrectly. When he visits the tree he creates a new survey and inputs all the data; suddenly, his 4G network loses connectivity; however, the application is still able to store all user input. Paul is aware that the network has disconnected but the app is stable. After he finishes updating the record, he clicks "Save"  The app saves the record to his device, and when connected back to the internet, the app is able to communicate with the server to save his data. There was no data loss!
-  Mobile users on hikes, walks, one-handed input  of data on the spot during real-time observation
- On the desktop at home, upload data in a more casual environment with saved photos

## :movie_camera: Story Board
![USER STORY 1 & =2](https://github.com/hkuspace-pu/project-submission-group-10-HKNatureWatch/blob/main/ProjectDocs/user_story_1_2.jpg)
![USER_STORY 3](https://github.com/hkuspace-pu/project-submission-group-10-HKNatureWatch/blob/main/ProjectDocs/group%20project%20prouct%20plan%20user%20story%20(1).jpg)

## :straight_ruler: UML User Story Diagram
![NORMAL USER UML](https://github.com/hkuspace-pu/project-submission-group-10-HKNatureWatch/blob/main/ProjectDocs/HK%20TREE%20WATCH%20NORMAL%20USER.drawio.png)

## :eyes: Features And Functional Requirements
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

## :exclamation: Constraints
- Focus on Trees at this moment with the possibility to expand the scope to other species, i.e. birds and trees in the future.
- PWA Limitations (Browser API's may not be fully supported, but they do offer 90% of requirements) And we feel this is the way forward to increse adoption rather then being in the app store which is often difficult to find.
- Apple IOS does support PWA, but it does have some limitations on its support; users can always fall back to the website.

 ## :earth_asia: Product Roadmap and Release Plan Guideline
- This Roadmap is a guideline not a rule; refer to Backlog for more up-to-date release information
- MVP to be released by Marketplace demo 11/Jan/2023
- V1 TO be released by 15/Feb/2023, which contains most of the high priority backlog items
- V1.2 to be released by 25/Feb/2023, which contains all/most of the medium priority backlog items finished
- V1.3 to be released by 20/Mar/2023, which contains all/most of the low priority backlog items finished
- V.1.3.1 will be released 5/Apr/2023 and contain bug fixed for all/most high-priority backlog items
- V.1.3.2 will be released for bug fixes for all medium and low priority items.
- V.1.5 General Release will be released by 1/May/2023 
- V.1.5.2 Stretch release will include stretch goals thereafter 


## :art: User Interface And Design Principles
- Responsive application
- Progress WEB Application 
-  We will constantly iterate after several rounds of usability testing and feedback
- Follow common design principles such as Visibility, Feeback, Constraints, Consistency & Affordance (Interaction Design, SHARP, 2019). This will help our application have a good user experience, 
 For example 
(Feedback) Give the user feedback or error notifications for incorrect validations or failed inputs. 
(Constrains) specific features for different types of user roles may be hidden or dimmed.
(Visibility) by making it clear to the user what to do next and where to click.

Link to MOOD BOARD : [Brand Color Kit](https://github.com/hkuspace-pu/project-submission-group-10-HKNatureWatch/blob/main/ProjectDocs/Olivia%20Wilson.pdf)

| Color             | Hex                                                                |
| ----------------- | ------------------------------------------------------------------ |
| Primary Color |  ![#87986A](https://via.placeholder.com/15/87986A) |
| Primary Color | ![#87986A](https://via.placeholder.com/15/87986A) |
| Secondary Color | ![#393E46](https://via.placeholder.com/15/B8C8AC) |
| Accent Color | ![#00ADB5](https://via.placeholder.com/15/B8B4B0)  |
| Text Color | ![#EEEEEE](https://via.placeholder.com/15/EEEEEE)  |
| Emphasis Color | ![#3E3D56](https://via.placeholder.com/15/3E3D56) |



## :computer: Hardware Requirements
- Mobile Phone
- Tablet
- Desktop or Laptop Computer
- Wired / Wireless / Mobile internet connection
- Offline once app/client side has been downloaded


## COMMUNICATION INTERFACE REQUIREMENTS 
- Email notifications?
- SMS notifications?


## :guardsman: Usability Study
![Usability Study Image](https://github.com/hkuspace-pu/project-submission-group-10-HKNatureWatch/blob/main/ProjectDocs/usability_study/Usability%20Study%20Image.jpeg)
![Usability Study Image](https://github.com/hkuspace-pu/project-submission-group-10-HKNatureWatch/blob/main/ProjectDocs/usability_study/Usability%20Study%20Image2.jpeg)


## :raised_hands: Boundaries for success
- For a stories for our team to be done, it has been code reviewed and all errors fixed, as well as tested in the pre-release environment

## :running: Sprint Cadence
- Each sprint cadence should be min 1 week to 4 week maximum (We will establish the shortest length as possible)

## :traffic_light: Risk Management Plan 


| Risk Identification  | Type    |  Probabilty L/M/H | Mitigation | Owner | Impact Level 1-5 | Impact Description |
| ----------------- | -------------------- | --| -- | -- | -- | -- |
| Personnel shortfalls |  Personnel | LOW | None | Group | 5 | If team member drops out, the rest of the group will have to take up the role. |
| Client requirements changing | Scope Creep  | Low |Communite with client, unable to make large changes, small changes if time persists|Group|3 |Project can be delayed if we accept too many requirements beyond original scope | 
| Client conflicts with their own requirments| Scope Creep | Medium | Communicate to client |Group|3 | Project Delays |
| Lack of sample data | Backend  |Medium|Add sample data | Leo |4 |Poor sample data will lead to a poor final demo to clinet|
| Poor HCI | Frontend  |Medium| Test on all devices, release early |Rishi, Simon |3 |Mobile users may not be able to complete surveys on smaller devices |
| API SSL | Backend |Medium |Apply Lets encrypt to backend API | Leo |5 |Browser will not be able to send requests to a secure endpoint|

Other Risks
----------
### Budget Risk
Given that this is a project for an NGO with a minimal budget, we are mandated to keep our costs as low as possible while delivering a high-quality product. Thus a heavy reliance on team cooperation and work ethic are of utmost importance while keeping the budget low.

**SOLUTION**
Using open source software and off-the-shelf products to design and implement the software without a burdening expense.

### Scope Creep
Scope creep is a phenomenon of the software development lifecycle; it happens when the client adds features that were not already discussed at the planning stage, thus increasing the cost and workload for our team and may push deadlines beyond the time limit set.

**SOLUTION**
Regular client meetings are necessary to ensure that plans are followed strictly to avoid scope creep. All stakeholders must be in agreement to the product backlog and the features that are required. Small and trivial additional features are usually acceptable.

### Time Constraints
  - Deadlines are often difficult to stick to due to the very nature of the software development lifecycle. Improper time management and lack of talent are several factors that can push deadlines and affect the completion of work.
  - 
**SOLUTION**
 - By using agile methodologies and sticking to deadlines for software releases as well as keeping a time buffer should alleviate most of the time delays that we may experien
  
### External Factors
  - Face-to-face client meetings may be hindered due to the current Covid-19 pandemic and the restrictions that are still present in Hong Kong. While some of the restrictions have been lifted, they have yet to be totally removed.
 
**SOLUTION**
  - Channels of communication such as Slack, Zoom will be utilized if incase such face-to-face meetings cannot take place, although meeting clients face to face is a preferred choice to obtain valuable feedback.    
    
### Security
  - Refer to Secruity Manifesto Document(ProjectDocs/HK TREE WATCH - Security.pdf)

**SOLUTION**
  - Follow OWASAP TOP 10. We can set up the network VPC for the service group, using firewall and WAF, using HTTPS instead of HTTP. Adding verification for the API requests.

## :cop: Legal social ethical and professional issues
Legal
- Compliance with local regulatory laws, Privacy Ordinance (PDPO) etc
- Does the client requirement is to disclose the source code of the software.
- Follow regulations provided by Office of [Government Cheif Information Office]
- State our copyright law and trademark rules if any.
- Create a (AUP) Acceptable Use Policy
- (https://www.ogcio.gov.hk/en/our_work/community/web_mobileapp_accessibility/faq/)
- Hong Kong does not have GPDR but instead has [PDPO](https://www.hk-lawyer.org/content/eu-gdpr-and-hk-pdpo-what%E2%80%99s-difference)
- Terms and conditions and Terms of use (do we force users to use our app in a certain way?)
- Professional liability insurance for local jurisdiction.  


Ethical
- Team Ethical Guideline Document Acceptance Document
[Link](https://github.com/hkuspace-pu/project-submission-group-10-HKNatureWatch/blob/main/ProjectDocs/Ethics/ETHICAL%20UNDERTAKING%20(2).pdf)
- Define a code of ethics and a general code of conduct to be signed by all team members
- Ensure that users on the platform do not discriminate, harass other members, or post vulgar, violent information.
- Users must sign up with their real username; we want to prevent pseudo names and do not want Trolls (i.e. twitter)
- Developers have the responsibility to protect user data.

Social
- Prevent online bullying on our forums or surveys or comments to other users.
- Prevent cultural dominance, i.e. no one race/cast of users can have power over another online on our website. Also English should not be the only laguage as it is the dominant one.
- Provide an avenue of redress i.e. email, contact, telephone if one of our users is being harmed by another user on our platform


## :telephone: Communication Plan
### Teammates
- We use WhatsApp, google drive, git, Teamgantt, and face-to-face meetings to communicate with teammates
- Teamgantt is our schedule. We mark down, what we are going to do and how long we prepare.
- We will submit our working in here. And Git can make a task or command.
- Whatsapp is the main communication. But we do not talk about any sensitive information. We will note teammates, whether we made changes somewhere or what we did. Our documents will store in google drive.

### Client
- We communicate to client by using email and regular meetings, on site demos

## :minidisc: Tech Stack
MODEL VIEW CONTROLLER (MVC APPROACH)
- JAVA for the Backend business logic and API
- MariaDB (mySQL) for our Database Model
- VueJS for our front end browser based view layer

## :runner: Sprint Plan

![Sprint Action Plan](https://github.com/hkuspace-pu/project-submission-group-10-HKNatureWatch/blob/main/KanBan/sprint_screen.jpeg)

- Closer of issues Final

All open issues have been resolved and now closed

![image](https://github.com/hkuspace-pu/project-submission-group-10-HKNatureWatch/assets/5736415/a8ae61b3-774c-4db2-8f59-69884a9c8b7c)

- Backlog Update

All backlogs have been completed, and resolved

![image](https://github.com/hkuspace-pu/project-submission-group-10-HKNatureWatch/assets/5736415/b00266b8-6710-45b4-b2ef-57b766a8d53f)


- [:runner:  Final Handover of project]

## Final Hanover of project

- 30 May 2023 is the final deadline, on this date all 3 members of the team will demonstate the project to the client and answer any Q&A
- Final report will handed over thereafter




