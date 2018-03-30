# tweeter

## Introduction

Tweeter is an basic app like Twitter include 2 pages: 

+Compose a Tweet: allows users to post messages longer than 50 characters and Tweeter will split the message into parts and send multiple messages on the user's behalf, all of them meeting the 50 character requirement.

+Show List Tweet: Display the user's messages.

## Algorithm:  

The main Algrorithm to split message
   
           /**
         * @param tweet comment of user
         * @return list string split by rule (max 50 characters)
         */
        fun splitMessage(tweet: String): ArrayList<String> {
            val strings = ArrayList<String>()
            if (tweet.length <= 50) {
                strings.add(tweet)
                return strings
            } else {   
                val splitPattern = Pattern.compile("(.{1,46})\\b( |$)")
                val m = splitPattern.matcher(tweet)
                while (m.find()) {
                    strings.add(m.group(1))
                }
                for (i in strings.indices) {
                    strings[i] ="${i + 1}/${strings.size} ${strings[i]}"
                }
            }

            return strings
        }
    
The Algrorithm to check valid comment

           /**
         *
         * @param comment is input of user
         * @return data valid or invalid
         */
        fun checkInvalidData(comment: String): Boolean {

            val pattern = Pattern.compile("\\s{51}")
            val matcher = pattern.matcher(comment)
            val check = matcher.find()

            return !check
        }


#Architect

The Architect used on this project is MVP architecture

![alt text](https://cdn-images-1.medium.com/max/1600/1*p2JvbgEir0BusDiiVHMvIA.png
)


