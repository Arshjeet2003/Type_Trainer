package com.example.android.typer;

import java.util.StringTokenizer;

public class data {
    public final String basic_data = "Certainly$" + "Good afternoon.$" + "Good evening sir.$" + "Good Luck.$" + "Good morning.$" + "Great.$" + "Happy Birthday.$" + "Have a good trip.$" +
            "Hello.$" + "ability$" + "able$" + "about$" + "above$" + "accept$" + "according$" + "account$" + "across$" + "act$" + "action$" + "activity$" + "actually$" + "add$" + "address$" + "administration$" + "admit$" + "adult$" + "affect$" +
            "after$" + "again$" + "against$" + "age$" + "agency$" + "agent$" + "ago$" + "agree$" + "agreement$" + "ahead$" + "air$" + "all$" + "allow$" + "almost$" + "alone$" + "along$" + "already$" + "also$" + "although$" + "always$" + "American$" + "among$" + "amount$" + "analysis$" + "and$" +
            "animal$" + "another$" + "answer$" + "any$" + "anyone$" + "anything$" + "appear$" + "apply$" + "approach$" + "area$" + "argue$" + "arm$" + "around$" + "arrive$" + "art$" + "article$" + "artist$" + "as$" + "ask$" + "assume$" +
            "at$" + "attack$" + "attention$" + "attorney$" + "audience$" + "author$" + "authority$" + "available$" + "avoid$" + "away$" + "baby$" + "back$" + "bad$" + "bag$" + "ball$" + "bank$" + "bar$" + "base$" + "be$" + "beat$" + "beautiful$" + "because$" + "become$" + "bed$" + "before$" + "begin$" + "behavior$" + "behind$" + "believe$" + "benefit$" + "best$" + "better$" + "between$" + "beyond$" + "big$" +
            "bill$" + "billion$" + "bit$" + "black$" + "blood$" + "blue$" + "board$" + "body$" + "book$" + "born$" + "both$" + "box$" + "boy$" + "break$" + "bring$" + "brother$" + "budget$" + "build$" + "building$" + "business$" + "but$" + "buy$" + "by$" + "call$" + "camera$" + "campaign$" + "can$" +
            "cancer$" + "candidate$" + "capital$" + "car$" + "card$" + "care$" + "career$" + "carry$" + "case$" + "catch$" + "cause$" + "cell$" + "center$" + "central$" + "century$" + "certain$" + "certainly$" + "chair$" + "challenge$" + "chance$" + "change$" + "character$" + "charges" +
            "check$" + "child$" + "choice$" + "choose$" + "church$" + "citizen$" + "city$" + "civil$" + "claim$" + "class$" + "clear$" + "clearly$" + "close$" + "coach$" + "cold$" + "collection$" + "college$" + "color$" + "come$" + "commercial$" + "common$" + "community$" + "company$" + "compare$" + "computer$";

    public final String intermediate_data = "Nice to meet you$" + "Please call me.$" + "Be careful.$" + "Be careful driving.$" + "Can you translate this for me?$" +
            "Chicago is very different from Boston.$" + "Don't worry.$" + "Everyone knows it.$" + "Everything is ready.$" + "Excellent.$" + "From time to time.$" + "Good idea.$" + "He likes it very much.$" + "Help!$" + "He's coming soon.$" + "He's right.$" + "He's very annoying.$" + "He's very famous.$" + "How are you?$" +
            "How's work going?$" + "Hurry!$" + "I ate already.$" + "I can't hear you.$" + "I'd like to go for a walk.$" + "I don't know how to use it.$" +
            "I don't like him.$" + "I don't like it.$" + "I don't speak very well.$" + "I don't understand.$" + "I don't want it.$" + "I don't want that.$" +
            "I don't want to bother you.$" + "I feel good.$" + "If you need my help, please let me know.$" + "I get off of work at 6.$" + "I have a headache.$" +
            "I hope you and your wife have a nice trip.$" + "I know.$" + "I like her.$" + "I'll call you when I leave.$" + "I'll come back later.$" +
            "I'll pay.$" + "I'll take it.$" + "I'll take you to the bus stop.$" + "I lost my watch.$" + "I love you.$" + "I'm an Indian.$" + "I'm cleaning my room.$" +
            "I'm cold.$" + "I'm coming to pick you up.$" + "I'm going to leave.$" + "I'm good, and you?$" +
            "I'm happy.$" + "I'm hungry.$" + "I'm married.$" + "I'm not busy.$" + "I'm not married.$" + "I'm not ready yet.$" + "I'm not sure.$" + "I'm sorry, we're sold out.$" + "I'm thirsty.$" +
            "I'm very busy. I don't have time now.$" + "I need to change clothes.$" +
            "I need to go home.$" + "I only want a snack.$" + "Is Mr. Smith an American?$" + "Is that enough?$" + "I think it's very good.$" + "I think it tastes good.$" +
            "I thought the clothes were cheaper.$" + "It's longer than 2 miles.$" +
            "I've been here for two days.$" + "I've heard Texas is a beautiful place.$" + "I've never seen that before.$" + "I was about to leave the restaurant when my friends arrived.$" + "Just a little.$" +
            "Just a moment.$" + "Let me check.$" + "Let me think about it.$" + "Let's go have a look.$" + "Let's practice English.$" + "May I speak to Mrs. Smith please?$" + "More than that.$" + "Never mind.$" + "Next time.$" +
            "No.$" + "Nonsense.$" + "No, thank you.$" + "Nothing else.$" + "Not recently.$" + "Not yet.$" + "Of course.$" + "Okay.$" + "Please fill out this form.$" +
            "Please take me to this address.$" + "Please write it down.$" + "Really?$" + "Right here.$" + "Right there.$" + "See you later.$" + "See you tomorrow.$" +
            "See you tonight.$" + "She's pretty.$" + "Sorry to bother you.$" + "Stop!$" + "Take a chance.$" + "Take it outside.$" + "Tell me.$" + "Thanks for everything.$" +
            "Thanks for your help.$" + "Thank you.$" + "Thank you miss.$" + "Thank you sir.$" + "Thank you very much.$" + "That looks great.$" + "That's alright.$" + "That's enough.$" +
            "That's fine.$" + "That's it.$" + "That smells bad.$" + "That's not fair.$" + "That's not right.$" + "That's right.$" + "That's too bad.$" +
            "That's too many.$" + "That's too much.$" + "The book is under the table.$" + "They'll be right back.$" + "They're the same.$" + "They're very busy.$" +
            "This doesn't work.$" + "This is very difficult.$" + "This is very important.$" + "Try it.$" + "Very good, thanks.$" + "We like it very much.$" +
            "Would you take a message please?$" + "Yes, really.$" + "You're beautiful.$" + "You're very nice.$" + "You're very smart.$" + "Your things are all here.$";

    public final String hard_data = "The Moon is a barren, rocky world without air and water.$" +
            " It has dark lava plain on its surface.$" +
            " The Moon is filled wit craters.$" +
            " It has no light of its own.$" +
            " It gets its light from the Sun.$" +
            " The Moon keeps changing its shape as it moves round the Earth.$" +
            " It spins on its axis in 27.3 days$" +
            " Edwin Aldrin were the first ones to set their foot on the Moon on 21 July 1969$." +
            " They reached the Moon in their space craft named Apollo II.$" +
            " The sun is a huge ball of gases.$" +
            " It has a diameter of 1,392,000 km.$" +
            " It is so huge that it can hold millions of planets inside it.$" +
            " The Sun is mainly made up of hydrogen and helium gas.$" +
            " The surface of the Sun is known as the photosphere.$" +
            " The photosphere is surrounded by a thin layer of gas known as the chromospheres.$" +
            " Without the Sun, there would be no life on Earth.$" +
            " There would be no plants, no animals and no human beings.$" +
            " As, all the living things on Earth get their energy from the Sun for their survival.$" +
            " The Solar System consists of the Sun Moon and Planets.$" +
            " It also consists of comets, meteoroids and asteroids.$ The Sun is the largest member of the Solar System.$" +
            " The Sun is at the centre of the Solar System and the planets, asteroids, comets and meteoroids revolve around it.$" +
            " The Mahabharata is a story about a great battle between the Kauravas and the Pandavas.$" +
            " The battle was fought in Kurukshetra near Delhi.$" +
            " Many kings and princes took part in the battle.$" +
            " The Pandavas defeated the Kauravas.$" +
            " The Bhagvad Gita is a holy book of the Hindus.$" +
            " It is a part of the Mahabharata.$" +
            " It is a book of collection of teachings of Lord Krishna to Arjuna in the battlefield.$" +
            " It is the longest epic in the world.$" +
            " The Ramayana is a story of Lord Rama written by the SageValmiki.$" +
            " Lord Rama, the prince of Ayodhya, in order to help his father Dasharatha went to exile for fourteen years.$" +
            " His wife, Sita and his younger brother Lakshmana also went with him.$" +
            " He went through many difficulties in the forest. One day Ravana, the king of Lanka carried away Sita with him.$" +
            " Then, Lord Rama, with the help of Hanumana, defeated and killed Ravana;$" +
            " Sita, Rama and Lakshmana returned to Ayodhya after their exile.$" +
            " The Taj Mahal is a beautiful monument built in 1631 by an Emperor named Shah Jahan in memory of his wife Mumtaz Mahal.$" +
            " It is situated on the banks of river Yamuna at Agra.$" +
            " It looks beautiful in the moonlight.$" +
            " The Taj Mahal is made up of white marble.$" +
            " In front of the monument, there is a beautiful garden known as the Charbagh.$" +
            " Inside the monument, there are two tombs.$" +
            " These tombs are of Shah Jahan and his wife Mumtaz Mahal.$" +
            " The Taj Mahal is considered as one of the Seven Wonders of the World.$" +
            " Many tourists come to see this beautiful structure from different parts of the world.$" +
            " Delhi is the capital of India.$" +
            " It is situated on the banks of the river Yamuna.$" +
            " It is surrounded by Haryanaand Uttar Pradesh.$" +
            " It has some of the famous buildings and monuments such as the Qutub Minar, Reu Fort, Lotus Temple, Akshardham Temple etc.$" +
            " Some of the monuments are hundreds of years old.$" +
            " Apart from this, there is the Parliament House, the Central Secretariat and the famous Connaught place.$" +
            " Delhi is a beautiful city.$" +
            " But, it is becoming very crowded and polluted.$" +
            " I love Delhi a lot.$" +
            " A snake charmer is a person who moves the streets with different types of the banks of the river Yamuna.$" +
            " It is snakes in his basket.$" +
            " He goes from one place to another to show various types of snakes and their tricks.$" +
            " He carries a pipe with which he plays music and snakes dance to his tune.$" +
            " He usually wears a colourful dress.$" +
            " The job of a snake charmer is quite dangerous.$" +
            " Some snakes are quite poisonous and can even bite him.$" +
            " It is not an easy task to catch and train them for the shows.$" +
            " A street beggar can be seen everywhere; at the bus stop, railway stations, religious places, markets etc.$" +
            " Some beggars are crippled, lame and some are blind.$" +
            " They are unable to earn their livelihood.$" +
            " Whereas some are healthy and they do not deserve our sympathy.$" +
            " We should see that they take up some profession.$" +
            " They should not be allowed to beg.$" +
            " On my way to school I see a beggar daily.$" +
            " He wears old rags.$" +
            " He is partially blind.$" +
            " I feel pity seeing him but I can’t help it I can only pray to God to help him to earn his livelihood.$" +
            " The doctor is a person who looks after the sick people and prescribes medicines so that the patient recovers fast.$" +
            " In order to become a doctor, a person has to study medicine.$" +
            " Doctors lead a hard life.$" +
            " Their life is very busy.$" +
            " They get up early in the morning and go to the hospital.$" +
            " They work without taking a break.$" +
            " They always remain polite so that patients feel comfortable with them.$" +
            " Since doctors work so hard we must realise their value.$" +
            " A hawker is a person who moves from one place to another and sell their goods, by shouting on the streets.$" +
            " They work hard throughout the day.$" +
            " They move on the street on their bicycle and sometimes on foot and sell their products.$" +
            " We can see hawkers everywhere.$" +
            " They move everywhere selling their goods without caring about the weather.$" +
            " There is a hawker who sells vegetables on his bicycle in our locality.$" +
            " His name is Manoj.$" +
            " He brings fresh vegetables at a very reasonable price.$" +
            " He is a nice and an honest hawker.$" +
            " India is an agricultural country.$" +
            " Most of the people live in villages and are farmers.$" +
            " They grow cereals, pulses, vegetables and fruits.$" +
            " The farmers lead a tough life.$" +
            " They get up early in the morning and go to the fields.$" +
            " They stay and work on the farm late till evening.$" +
            " The farmers usually live in kuchcha houses.$" +
            " Though, they work hard they remain poor.$" +
            " Farmers eat simple food; wear simple clothes and rear animals like cows, buffaloes and oxen.$" +
            " Without them there would be no cereals for us to eat.$" +
            " They play an important role in the growth and economy of a country.$";

    public String[] sentences_array(int i) {
        StringTokenizer st;
        if (i == 1) {
            st = new StringTokenizer(basic_data, "$");
        } else if (i == 2) {
            st = new StringTokenizer(intermediate_data, "$");
        } else {
            st = new StringTokenizer(hard_data, "$");
        }
        int n = st.countTokens();
        String[] sentences = new String[n];
        int j = 0;
        while (st.hasMoreTokens()) {
            sentences[j] = st.nextToken();
            j++;
        }
        return sentences;
    }
}
