I updated the code and uploaded a video of the working app as working-app-video.mp4 in the root directory of this repo.

Here is a quick summary of the changes I made to the code:

  * Added the integer `position` of the item clicked as an extra to the intent being passed to PositionActivity
  * Called `notifyDataSetChanged()` on `mAdapter` after updating `mStatesArray` to be an empty array
  * Commented out the second, unnecessary text view in the list view item in both list_view_item.xml and in MainActivity
  * Added a constant in MainActivity to serve as the key for the `position` intent extra to avoid using a hardcoded key which could cause an error if updated in on place (MainActivity or PositionActivity) but not the other

Thanks,

Charlie


# Android Development Instructional Support Code Challenge

Thanks for your interest in becoming an IA or TA for General Assembly's Android Development course! The following code challenge is designed to test your ability to troubleshoot and repair a broken Android app.  

## Technical Specs

We've provided you with [some starter code in this repo](/TestApplication/). Go ahead and run this code in Android Studio. The code provided is broken in a few fundamental ways and will not run properly. Please fix the broken code to implement the following three features:

**1. When opened, the app should display a list of abbreviations of U.S. states, as seen in the screenshot below:**
![List of states](./screenshots/screen1.png)

**2. Clicking on a state abbreviation should take the user to a page that displays that state's position in the list:**
![State view](./screenshots/screen2.png)

**3. Clicking the red "delete" button on the main screen should erase the entire list of abbreviations.**
![Delete button](./screenshots/screen3.png)

## How to submit

1. Clone this repo and begin working on your solution--please don't fork this repo, otherwise it will be easy for others to find your solution!
2. Once you've successfully implemented the three features, take a video of the working app, demoing the three features. If you've never recorded a video using Android Studio, [see this article](http://developer.android.com/tools/debugging/debugging-studio.html#screenCap) for instructions.
3. When you're all done, **please submit both your video and a link to your code on GitHub** to your producer or recruiter.
