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
    
    public static ArrayList<String> splitMessage(String tweet) {
        ArrayList<String> strings = new ArrayList<>();
        
        //tweet less than or equal to 50 characters
        if (tweet.length()<=50) {
            strings.add(tweet);
            return strings;
        } else { 
        
            //tweet more 50 characters
            //group(1) means that I only need the first part of the pattern (.{1,46}) as output.
            //.{1,46} - a sequence of any characters (".") with any length between 1 and 46 ({1,46})
            //\b - a word break (a non-character before of after any word)
            //( |$) - space or end of string
            
            Pattern splitPattern = Pattern.compile("(.{1,46})\\b( |$)");
            Matcher m = splitPattern.matcher(tweet);
            while (m.find()) {
                strings.add(m.group(1));
            }
            for (int i = 0; i < strings.size(); i++) {
                strings.set(i, i + 1 + "/" + strings.size() + " " + strings.get(i));
            }
        }

        return strings;
    }
    
The Algrorithm to check valid comment

    /**
     *
     * @param comment is input of user
     * @return data valid or invalid
     */
    
    public static boolean checkInvalidData(String comment)
    {
        // find a non-whitespace characters longer than 50 characters
        Pattern pattern = Pattern.compile("\\s{51}");
        Matcher matcher = pattern.matcher(comment);
        boolean check = matcher.find();

        if(check)
        {
            //the message contains a span of non-whitespace characters longer than 50 characters, return false
            return false;
        }
        return true;
    }


#Architect

The Architect used on this project is MVP architecture

![alt text](https://cdn-images-1.medium.com/max/1600/1*p2JvbgEir0BusDiiVHMvIA.png
)


