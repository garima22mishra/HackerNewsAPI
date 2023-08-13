# HackerNewsAPI
# To open project in Eclipse IDE:
File -> Open Projects from File System -> Import Source -> In Directory select "HackerNewsAPI".


#To Run the project: 
Right click on HackerNewsAPI -> Run as -> Run on Server -> Select Tomcat v8.5 Server or above.


#On REST API tester provide the following details to run the APIs.

Request header:
Content-Type: application/x-www-form-urlencoded
Authorization: No Auth 

#Request-Response Format:

1. top-stories:
URL: 
http://localhost:8080/HackerNewsAPI/api

Request Body:
action: top-stories

Response:
{
    "Status": "Success",
    "Data": [
        {
            "title": "Downfall Attacks",
            "url": "https://downfall.page/",
            "score": 1295,
            "timeOfSubmission": 1691515658,
            "user": "WalterSobchak"
        },
        {
            "title": "I'm 17 and wrote this guide on how CPUs run programs",
            "url": "https://github.com/hackclub/putting-the-you-in-cpu",
            "score": 1280,
            "timeOfSubmission": 1691588039,
            "user": "archmaster"
        },
        {
            "title": "Vim Boss",
            "url": "https://neovim.io/news/2023/08",
            "score": 1127,
            "timeOfSubmission": 1691686934,
            "user": "bpierre"
        },
        {
            "title": "Temptations of an open-source Chrome extension developer (2021)",
            "url": "https://github.com/extesy/hoverzoom/discussions/670",
            "score": 1074,
            "timeOfSubmission": 1691605710,
            "user": "hk__2"
        },
        {
            "title": "Uninstall the NightOwl app",
            "url": "https://robins.one/notes/uninstall-the-nightowl-app-now.html",
            "score": 1000,
            "timeOfSubmission": 1691515380,
            "user": "txr"
        },
        {
            "title": "TSMC, Bosch, Infineon, NXP to jointly build semiconductor fab in Europe",
            "url": "https://pr.tsmc.com/english/news/3049",
            "score": 838,
            "timeOfSubmission": 1691491700,
            "user": "king_phil"
        },
        {
            "title": "Want employees to return to the office? Then give each one an office",
            "url": "https://www.washingtonpost.com/opinions/2023/08/09/remote-work-offices-floorplan-privacy/",
            "score": 789,
            "timeOfSubmission": 1691589153,
            "user": "fortran77"
        },
        {
            "title": "CNET is deleting old articles to try to improve its Google Search ranking",
            "url": "https://www.theverge.com/2023/8/9/23826342/cnet-content-pruning-deleting-articles-google-seo",
            "score": 760,
            "timeOfSubmission": 1691615452,
            "user": "mikece"
        },
        {
            "title": "What happened in this GPT-3 conversation?",
            "url": "https://chat.openai.com/share/f5341665-7f08-4fca-9639-04201363506e",
            "score": 683,
            "timeOfSubmission": 1691522839,
            "user": "hersko"
        },
        {
            "title": "Your computer should say what you tell it to say",
            "url": "https://www.eff.org/deeplinks/2023/08/your-computer-should-say-what-you-tell-it-say-1",
            "score": 674,
            "timeOfSubmission": 1691506996,
            "user": "skilled"
        }
    ]
}

2. past-stories
URL: 
http://localhost:8080/HackerNewsAPI/api

Request Body:
action: past-stories

Response:
{
    "Status": "Success",
    "Data": [
        {
            "title": "Vim Boss",
            "url": "https://neovim.io/news/2023/08",
            "score": 1246,
            "timeOfSubmission": 1691686934,
            "user": "bpierre"
        },
        {
            "title": "TSMC, Bosch, Infineon, NXP to jointly build semiconductor fab in Europe",
            "url": "https://pr.tsmc.com/english/news/3049",
            "score": 851,
            "timeOfSubmission": 1691491700,
            "user": "king_phil"
        },
        {
            "title": "CNET is deleting old articles to try to improve its Google Search ranking",
            "url": "https://www.theverge.com/2023/8/9/23826342/cnet-content-pruning-deleting-articles-google-seo",
            "score": 783,
            "timeOfSubmission": 1691615452,
            "user": "mikece"
        },
        {
            "title": "The Future of the Vim Project",
            "url": "https://groups.google.com/g/vim_dev/c/dq9Wu5jqVTw",
            "score": 672,
            "timeOfSubmission": 1691665050,
            "user": "mrzool"
        },
        {
            "title": "I'm 17 and wrote this guide on how CPUs run programs",
            "url": "https://github.com/hackclub/putting-the-you-in-cpu",
            "score": 1311,
            "timeOfSubmission": 1691588039,
            "user": "archmaster"
        },
        {
            "title": "Temptations of an open-source Chrome extension developer (2021)",
            "url": "https://github.com/extesy/hoverzoom/discussions/670",
            "score": 1100,
            "timeOfSubmission": 1691605710,
            "user": "hk__2"
        },
        {
            "title": "Squeeze the hell out of the system you have",
            "url": "https://blog.danslimmon.com/2023/08/11/squeeze-the-hell-out-of-the-system-you-have/#like-2777",
            "score": 655,
            "timeOfSubmission": 1691777882,
            "user": "sbmsr"
        },
        {
            "title": "Downfall Attacks",
            "url": "https://downfall.page/",
            "score": 1320,
            "timeOfSubmission": 1691515658,
            "user": "WalterSobchak"
        },
        {
            "title": "Firefox desktop extensions coming soon for the upcoming Android release",
            "url": "https://blog.mozilla.org/addons/2023/08/10/prepare-your-firefox-desktop-extension-for-the-upcoming-android-release/",
            "score": 808,
            "timeOfSubmission": 1691723370,
            "user": "rc00"
        },
        {
            "title": "Want employees to return to the office? Then give each one an office",
            "url": "https://www.washingtonpost.com/opinions/2023/08/09/remote-work-offices-floorplan-privacy/",
            "score": 808,
            "timeOfSubmission": 1691589153,
            "user": "fortran77"
        }
    ]
}

3. comments
URL: 
http://localhost:8080/HackerNewsAPI/api

Request Body:
action: comments
id: 37045417

Response:
{
    "Status": "Success",
    "Data": [
        {
            "comment": "This is actually fantastic. But I&#x27;m saying this not for the reasons you might expect.<p>As others have noted, lots of inaccurate information here. The AI has stuff that it is regurgitating that is totally out of date, or just plain wrong.<p>But, if you are concerned by that, then you don&#x27;t know why travel sites exist. They exist to sell you something. All of these existing sites are lying, whether it is about the hotels or the amenities, or whatever. You are getting a manipulated filter at best, or just advertising at worst.<p>For this reason, this is, in my opinion, the best application of AI I&#x27;ve seen this year. It&#x27;s an equivalent product in almost every way, but probably costs 1&#x2F;100th the price to create for anyone without AI. The future of travel sites. The second order effects will be terrifying to behold.",
            "user": "xrd"
        },
        {
            "comment": "The code for the website is open source: <a href=\"https:&#x2F;&#x2F;github.com&#x2F;riesvile&#x2F;meoweler-fe\">https:&#x2F;&#x2F;github.com&#x2F;riesvile&#x2F;meoweler-fe</a>",
            "user": "levmiseri"
        },
        {
            "comment": "Nice! I?m looking at an AI website designer product this morning!<p>Any competitor AI service stuck in waitlist is vaporware, things that are live are refreshing",
            "user": "yieldcrv"
        },
        {
            "comment": "Where are you getting the data for things like &quot;internet situation&quot; and expense? Are you using third-party APIs or is that content output from GPT4? Would be interested in reading about how you put it all together (and your motivation!).",
            "user": "hiatus"
        },
        {
            "comment": "I?m from Napoli and I think its quite accurate expect for walking hostile? Why? I walk for hours every day, ignore bike and public transport and just walk around with friends why is it reported as walking hostile?:(",
            "user": "lnxg33k1"
        },
        {
            "comment": "How much did it cost to generate the content for this site? Would love to hear the breakdown of costs Midjourney vs. GPT, etc.",
            "user": "jondwillis"
        },
        {
            "comment": "so the splash image is generated by midjourney.<p>@levmiseri are you using APIs, or have fine-tuned prompts for each of the location? do share these as well. the github doesn&#x27;t include this.",
            "user": "anagri"
        },
        {
            "comment": "I checked the city of C�rdoba in Argentina [1] to pick something outside the well-known ones (and even then, it&#x27;s the second or third biggest city in the country). The results are not good:<p>* Opening picture: Not an accurate representation of C�rdoba, it&#x27;s way too hilly. Also, there&#x27;s a fluffy abomination of nature on the right.<p>* &quot;Land of Tango Thrills and Siesta Chills&quot;: this is so stereotypical as to be almost offensive. I met exactly one person who knows how to dance tango in about 10 years.<p>* &quot;Stretch those paws in Cordoba, a purr-fect playground for curious cats seeking whisker-tingling adventures!&quot;: this is completely information free.<p>* According to TravelSafe [2] there&#x27;s a medium risk of muggings and high risk of pickpockets so I would not recommend &quot;lounging in sunbathed plazas&quot; as a tourist unless you know which ones are safe.<p>* Off the beaten path: &quot;Feria de Mataderos&quot; is in Buenos Aires, 700km away, and I challenge you to look at the Google Maps pictures of &quot;El Bosquecito&quot; and tell me it&#x27;s a good place for tourists. Also, which &quot;El Bosquecito&quot; in Google Maps is the correct one? Because there are several.<p>* &quot;Get lost in the maze-like streets of the Old Town&quot;: that&#x27;s Prague you are thinking of. The streets in the old part of C�rdoba are almost perfectly square.<p>* &quot;Taste the city&#x27;s typical dish: locro&quot;: Yeah, no. There is locro to be found, but it&#x27;s not C�rdoba&#x27;s typical dish.<p>* Lightning round question: why is C�rdoba &quot;LGBTQ friendly&quot; while R�o Cuarto (same Province, 200k South) is &quot;LGBTQ tolerated&quot;?<p>And since we are in Argentina, the pictures for Posadas [3] and Resistencia [4] <i>are</i> offensively wrong. The description for Corrientes [5] (whose content and picture are not any better, including a &quot;mainstream attraction&quot; that&#x27;s 300km away and in a different Province) reads &quot;Where the Tango Comes Alive&quot;. Seeing a pattern yet?<p>This is to me a cautionary tale of the type of bad content that AI will generate (or, realistically, is already generating). I give it points for having a &quot;generated with AI&quot; sign, but I&#x27;m not looking forward to even more content claiming that everyone in Argentina dances tango with their pet cows.<p>[1] <a href=\"https:&#x2F;&#x2F;meoweler.com&#x2F;arga&#x2F;cordoba\" rel=\"nofollow noreferrer\">https:&#x2F;&#x2F;meoweler.com&#x2F;arga&#x2F;cordoba</a><p>[2] <a href=\"https:&#x2F;&#x2F;www.travelsafe-abroad.com&#x2F;argentina&#x2F;cordoba&#x2F;\" rel=\"nofollow noreferrer\">https:&#x2F;&#x2F;www.travelsafe-abroad.com&#x2F;argentina&#x2F;cordoba&#x2F;</a><p>[3] <a href=\"https:&#x2F;&#x2F;meoweler.com&#x2F;arga&#x2F;posadas\" rel=\"nofollow noreferrer\">https:&#x2F;&#x2F;meoweler.com&#x2F;arga&#x2F;posadas</a><p>[4] <a href=\"https:&#x2F;&#x2F;meoweler.com&#x2F;arga&#x2F;resistencia\" rel=\"nofollow noreferrer\">https:&#x2F;&#x2F;meoweler.com&#x2F;arga&#x2F;resistencia</a><p>[5] <a href=\"https:&#x2F;&#x2F;meoweler.com&#x2F;arga&#x2F;corrientes\" rel=\"nofollow noreferrer\">https:&#x2F;&#x2F;meoweler.com&#x2F;arga&#x2F;corrientes</a>",
            "user": "probably_wrong"
        },
        {
            "comment": "Could you be more specific about how much is GPT4?",
            "user": "cypress66"
        },
        {
            "comment": "Data about people, culture, language, tourist hotspots and whatever is slow-changing, so I think this is a good application for AI. Congrats.<p>Travel conditions, currency value etc, now those tend to surprise us more quickly and the cutoff point of the training set might lead to misleading info.<p>All in all, as a cat visitor, I find this amusing.",
            "user": "dormento"
        }
    ]
}
