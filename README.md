# **Cookie Reviews API**
#### **Introduction**
Our goal is to review different cookie flavors. An author can leave a short review of a cookie flavor on a 0-10 rating scale.

We can assign a review to a category (for example "American Classic" or "Seasonal"), and we can add hashtags (a short description such as "ChocolateTherapy"). We are able to find all reviews from a category or a hashtag if we choose to do so.

#### **Instructions**
1. Open CookieReviewsApplication in IntelliJ IDEA
    * Run the application
2. While the application is running, open Visual Studio Code.
    * Go to File - Open - review-api-cheyenneabel - build - resources
    
---
**To Access Reviews**

Send GET Request for "reviews" to see all reviews
_OR_ for "reviews/review Id number" to find a specific review by Id
    
    * example:  ###
                GET http://localhost:8080/reviews



**To Access Categories**

Send GET Request for "categories" to see all categories
_OR_ for "categories/category Id number" to find a specific category by Id

    * example: ###
               GET http://localhost:8080/categories

**To Access Hashtags**

Send GET Request to "hashtags" _OR_ to "hashtags/hashtag Id number" to find a specific hashtag by Id and all reviews

     * example:  ###
                 GET http://localhost:8080/hashtags

**To Add a New Review**

Send POST Request with Content-Type application/json. Add your review inside curly brackets with the fields shown in the example. Be sure to include empty array list in the hashtag field.

    * example: ###
               POST http://localhost:8080/reviews
               Content-Type: application/json
                { 
                    "author": "Cheyenne",
                    "rating": "10/10",
                    "flavor": "White Chocolate Macadamia",
                    "reviewText": "Full of elegant texture and sweetness.",
                    "hashtag": [ ]
                }
 
**To Add a New Category**

Send POST Request with Content-Type application/json. Add your category inside curly brackets with the fields shown in the example:

    * example: ###
               POST http://localhost:8080/categories
               Content-Type: application/json

               {
                   "categoryName": "Seasonal",
                   "occasion": "Valentine's Day",
                   "reviews": [ ]
               }

   * **To Add a Category To a Review:** Send PUT Request to "categories/categoryIdNumber/addToReview/reviewIdNumber

**To Add a New Hashtag**

Send POST Request with Content-Type application/json. Add your hashtag inside the curly brackets with the field shown in the example:

    * example: ###
               POST http://localhost:8080/hashtags
               Content-Type: application/json

               {
                  "description": "hashtagGoesHere"
               }
    
  * **To Add a Hashtag To a Review:** Send PUT Request to "hashtags/hashtagIdNumber/addToReview/reviewIdNumber

  * **To Access Reviews by Hashtag:** Send GET Request to "hashtags/hashtagIdNumber/getReviews"









