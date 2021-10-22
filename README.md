# marvelOpenBankTest
Openbank - Mobile Test

1) - For the operation of the app it is required to attach a file called secret.properties in the app folder
where there should be only two variables called

MARVEL_API_KEY = here public key from marvel site
MARVEL_PRIVATE_KEY = here private key from marvel site

2) - DESCRIPTION  
The simple version of an App connected to the Marvel Api where a list with the Marvel heroes is collected
and when pressing on one of them we go to the details page where the Marvel Api is called again with its id to collect its data

3) - APP NAME  
MarvelAppTest

4) - DURATION OF THE PRACTICE  
Start date: Tuesday 19 October 2021
Delivery date: Friday 22 October 2021

5) - ARCHITECTURE  
Clean Architectur modulated in layers where the layers are:
Domain- to collect the modules of the main API
Data- where the repositories and sources (interfaces that will have to be implemented in the app) are distributed to be used in the API calls
UseCase- Where we declare the use cases of each necessary action in the repositories
sharedMocks- Where I mock some hero data to be able to do testing
app- This is where all the business logic of the application is.

6) - DESIGN PATTERN    
MVVM (Model View View Model) is used as Patern Design, with livedatas and stateFlows

7) - TESTING  
Only Unit Testing in usecase & data layers with mockito & Junit

8) - LIBRARIES  
Retrofit- Necessary for communication between the App and the endpoints
Timber- for Logs
Glide- One of the options to visualize the collected images as url from the endpoin (more options would be "picaso" or "coil")
Paging3- jetpack library for paging results in the list.

- I have all the libraries grouped in the gradle.app so that they can be used in each layer separately whenever appropriate.
