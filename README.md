# Open Sky

💻A job recommendation web application.

## Latest Issues
- Fow now, Github Jobs API returns an empty result list for locations such as Los Angeles, Cupertino, Sunnyvale and other near-by California regions. The nearby feature is currently taken off and replaced by showing all job postings from Github Jobs API.
- Keyword Extraction used to be done by MonekyLearn API, but its free tier monthly usage is too small that it cannot sustain the large amount of job posting data needed to be filtered. 

## Screenshot Demo
**1. Homepage with general job listings**
![screenshot1](https://i.ibb.co/DtGydcZ/screenshot1.png)
**2. You can add a job listing to your favorites**
![screenshot2](https://i.ibb.co/JmHqftJ/screenshot2.jpg)
**3. See job listings in the favorites section**
![screenshot3](https://i.ibb.co/f97WLq1/screenshot3.jpg)
**4. See recommendations based on your favorite listings**
(system updating, will be added later)
## Technologies
 **Front-end**
 
 - HTML5/CSS
 - JavaScript
 
 **Back-end**
 
 - Java
 - Github Job API

  **Deployment**
  - Amazon EC2 (Linux Ubuntu instance managed using Docker)
## How do I see the website?
Because of APIs limitations stated in the above, a link to the website is available but the job listings are not showing up properly.
You can currently register for an account, login and logout after a while to test the session-based authentication implementation.
You can view the website using the link: http://52.53.166.56/jupiter/

