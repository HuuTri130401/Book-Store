insert Employee ([account_Id],[password],[fullName],[phone],[address],[gender],[role],[status_Employee])
values ('admin','21232f297a57a5a743894a0e4a801fc3',N'Trần Hữu Trí',
'0123456789',N'Hồ Chí Minh','Female','Admin',1)
insert Employee ([account_Id],[password],[fullName],[phone],[address],[gender],[role],[status_Employee])
values ('staff1','4d7d719ac0cf3d78ea8a94701913fe47',N'Nguyễn Tuấn Vũ',
'0397528860',N'Phú Yên','Male','Staff',1)
insert Employee ([account_Id],[password],[fullName],[phone],[address],[gender],[role],[status_Employee])
values ('seller1','95caed8e60e15871a6d12fe5505db2db',N'Nguyễn Quỳnh Chi',
'0123456789',N'Hồ Chí Minh','Female','Seller',1)
insert Employee ([account_Id],[password],[fullName],[phone],[address],[gender],[role],[status_Employee])
values ('seller2','c30248d146039dd086b12f18154863e1',N'Trần Hữu Trí',
'0123456789',N'Đồng Tháp','Male','Seller',1)

/*Insert Category*/

insert Category ([category_Name])
values ('Romance')
insert Category([category_Name])
values ('Self-help')
insert Category([category_Name])
values ('Novel')
insert Category([category_Name])
values ('Fantasy')

/* Insert Book*/

insert Book ([name_Book],[author_Book],[year_Of_Public],[category],[price_Book],[quantity_Book],
[image],[description_Book],[status_Book])
values (N'Bài Giảng Cuối Cùng','Randy Pausch',
2020,1,92000,10,'BGCC.jpg',N'Bài Giảng Cuối Cùng 
"We can not change the cards we have dealt, we can only change the way the cards are played." - Randy Pausch -
In fact, many professors were invited to give the "Last Lecture" before leaving the lecture hall. At that time, they often shared about failures as well as the quintessence drawn from
individual life and career. While listening to the presentation, the audience is always tormented by the question:
If this is our last chance, what message can we send to everyone? If I have to leave tomorrow
What do we want to be the legacy to leave for life?

When Randy Pausch, Professor of Informatics teaching at Carnegie Mellon, was asked to give such a lecture,
he figured it would be his last lecture, because he had just been diagnosed with terminal cancer.
But his lecture - "Touching Childhood Dreams" - is not about death but about overcoming
obstacles, about spreading the way to realize dreams to others and never letting anything go to waste
any moment in life (because "Time is all you have. One day you will realize how little you have."
than you think”). That is the philosophy that Randy draws from life.

In this book, Randy Pausch skillfully combines humor, engaging style, and wisdom.
poise, making his lectures a phenomenon that left an impression on the hearts of generations of readers. This is sure
It will be a book passed from hand to hand by future generations.',1)
insert Book([name_Book],[author_Book],[year_Of_Public],[category],[price_Book],[quantity_Book],
[image],[description_Book],[status_Book])
values (N'Đắc Nhân Tâm','Dale Carnegie',
2022,2,88000,15,'DNT.jpg',N'Đắc Nhân Tâm - How to win friends and Influence People by Dale Carnegie is a book
The most famous, best-selling and most influential of all time. The work has been translated into most of
languages ​​in the world and present in hundreds of countries. This is the only self-help book in the genre
Continue to top the list of best-selling books (best-selling Books) voted by The New York Times for 10 years in a row.
The English version of the book alone has sold more than 15 million copies worldwide.

The work has a very wide spread - no matter where you go, any country can see it.
The work is considered the first and best book, having an impact on changing the lives of millions of people
In the world. There is no longer the concept of a limitation. Dac Nhan Tam is the art of winning people is hearts, doing everything for everyone
everyone loves me. Dac Nhan Tam and the Talent in each of us.

Winning Nhan Tam in that sense should be acquired by understanding yourself, being honest with yourself, understanding and
care about the people around to see and reveal the hidden potential in them, help them develop
to a new level. This is the highest art of man and the deepest meaning drawn from
Dale Carnegie Golden Rules',1)
insert Book([name_Book],[author_Book],[year_Of_Public],[category],[price_Book],[quantity_Book],
[image],[description_Book],[status_Book])
values (N'Không Gia Đình','Hector Malot',
2022,1,110000,15,'KGD.jpg',N'Không gia đình Tells the story of Reemi is life. Since childhood, Reemi was kidnapped, then was
adoptive father followed a circus animal troupe. I followed that circus to wander all over France.

Remi grew up in hardship and worked to survive. At first, I was taught by old Vitali, later I
create. Not only taking care of myself, I also take care of performing and making a living for a troupe...

But no matter where, in any situation, I still follow the training of old vitali to keep the quality of being a human being. It is heart
love labor, self-respect, integrity, gratitude and always want to be useful.
No family is always attractive, attracting readers because of family affection. No Family is a good book about
education, deserves an award from the French Academy of Literature',1)
insert Book([name_Book],[author_Book],[year_Of_Public],[category],[price_Book],[quantity_Book],
[image],[description_Book],[status_Book])
values (N'Cuốn Theo Chiều Gió','Margaret Mitchell',
2020,3,228000,8,'CTCG.jpg',N'Set during the Civil War and reconstruction with fierce wars, deep contradictions
political, social, and post-war poverty, Gone with the Wind tells the story of Scarlett OHara, a young girl.
blue-eyed letter with proud Irish blood. From a sixteen-year-old girl who lives in velvet and fluff
Chasing love, Scarlett went through the most desperate days, tasted loss, to save the land of Tara
dear, save her family. But despite the storms of life, she still keeps her endless optimism.
And in the midst of turmoil, beside her there was still a brazen and careless Rhett Butler but always for
Scarlett love and tolerance, a tender and loving Melanie Hamilton who accompanies her through all the pain
love, as well as a gentle Ashley Wilkes always immersed in nostalgia. They all lived, loved and created
thus immortal literary images, erasing all standards, making readers both love and hate, remember and never forget.

As one of the most beloved works of all time, Gone with the Wind depicts a historical period
tragic history of America, both in its splendor and decay, to see there man with all his pros and cons,
defective, and love with all young, foolish, sometimes lost its way because of vanity, but in the end it is always love.',1)
insert Book([name_Book],[author_Book],[year_Of_Public],[category],[price_Book],[quantity_Book],
[image],[description_Book],[status_Book])
values (N'Lược Sử Thời Gian','Stephen Hawking',
2020,4,170000,12,'LSTG.jpg',N'Curiosity is one of our most important innate qualities, and
Topics such as What is the nature of the universe? Where did the universe come from? Where do we come from and what role do we play in the universe? There are genders
limit for human perception?... are questions that many generations of people have asked under
one form or another from the beginning of knowing and contemplating this world. All problems should be
published in the work A Brief History of Time such as the Expanding Universe, Black Holes, Origin and Fate of the Universe, Arrows of Time...
It is the author is wish to partially answer those questions, and to work towards explaining the stages
history of the entire universe.
With clear language, compelling arguments, and a witty wit, author Stephen Hawking sets out
tasked with describing the most complex things in physics in a way that was understandable to everyone, no
Use any mathematical formula, except Einstein is famous equation: E = mc2',1)
insert Book([name_Book],[author_Book],[year_Of_Public],[category],[price_Book],[quantity_Book],
[image],[description_Book],[status_Book])
values (N'Đi Tìm Lẽ Sống','Victor Frankl',
2020,2,78000,17,'DTLS.jpg',N'Usually, if a book has only one paragraph, one idea has the power to change
change a person is life, that alone is enough for us to read over and over and give it a
place on your bookshelf. This book has many such passages.

First of all, this is a book about survival. Like many Jews living in Germany and Eastern Europe when
Then, thinking he would be safe in the 1930s, Frankl had a rough time
fell in Nazi concentration camps and extermination camps. Miraculously he survived, the phrase “hardened steel”
That is it" can accurately describe this situation. But in Finding a reason to live, the author rarely mentions the hardships,
The pain and loss he experienced, he wrote instead about the sources of strength that kept him alive.

What the press said about "Finding a reason to live"

“The book helps you find your reason for living, your strength.” - Zing News

“Frankl is book helps readers see three basic sources of meaning in life: achievement at work,
care for loved ones and courage in the face of life is tough times.”
- Investment bridge

“Inspiring readers around the world for nearly a century, “In Search of a Reason” is a book that
We should all probably read it once on our way to finding meaning in our lives.” - Reading Station
',1)
insert Book([name_Book],[author_Book],[year_Of_Public],[category],[price_Book],[quantity_Book],
[image],[description_Book],[status_Book])
values (N'Cuộc đời của Pi','Yann Martel',
2020,2,78000,15,'CDCP.jpg',N'After the tragic shipwreck, Pi, the 16-year-old son of a zoo director, goes with his family
Canada, finds itself the sole survivor of a tiny lifeboat bobbing in the middle of the Pacific Ocean. Together
with a distressed zebra (a broken leg), an evil spotted hyena that kept yip yip, an orangutan
Vomiting from seasickness and especially a 450-pound Bengal tiger, Pi has been wandering the ocean for 227
day, hope and despair, experience the funniest, most terrifying, most paranoid, scariest...
that a person may encounter in life. Unlimited imagination, rich knowledge, deep experience
broad, masterful storytelling, these are the factors that helped Yann Martel write one of the most worthy books.
most read of contemporary world literature.

"Pi is life is a black magic that goes hand in hand with reality, a delicate and elaborate allegory of faith under many
class" - Irish Time

"If this century produces a cult classic, Martel is a strong contender" - The Nation

"Those who believe that the art of fiction is dying let them read Yann Martel to open their eyes" - Canongate

"There is a bit of a sea story, a glimpse of magical realism, the rest is full of genius.
the story that made Martel is novel"
',1)
insert Book([name_Book],[author_Book],[year_Of_Public],[category],[price_Book],[quantity_Book],
[image],[description_Book],[status_Book])
values (N'Vũ Trụ','Carl Sagan',
2021,4,126000,6,'VT.jpg',N'Thirteen beautiful stories about the Universe. Through the lyrical narration of Carl Sagan, the reader
will have the opportunity to travel in space, explore the world from the macrocosm of the great galaxies to the microscopic world of the
little bacteria on Earth, going from ancient civilizations to the future of the world, shows us the connection
organic bundles of every little thing with the vast universe and hear the multi-racial voices of the Universe. The universe pointed
An inanimate, chaotic universe, but also an ordered, sentient, humane and emotional world. Book of
Carl Sagan, a famous astronomer who has sold more than 5 million copies worldwide.
Praise for the Universe
“The Universe is like a college lecture on science that you always wanted to hear but did not know which professor
can teach. Sagan writes great. With a lyrical literary style, with the coverage of almost all aspects of knowledge
Humanity, the Universe is so ingenious that it seems unreal.”
– Cleveland Plain Dealer
“Carl Sagan is one of the most brilliant scientists of our time… He did the writing job.
excellent at digging into the past, present and future of science, at handling the mind-blowing immensity
brain of the universe in which we exist.”
- Associated Press
“Excellent in scale and challenging in hints. The book shimmers with a sense of wonder
strange… I am sure anyone who picks up this book will be drawn to it and feel inferior because of it."
- Miami Herald',1)
insert Book([name_Book],[author_Book],[year_Of_Public],[category],[price_Book],[quantity_Book],
[image],[description_Book],[status_Book])
values (N'Đọc Vị Bất Kỳ Ai','TS.David J. Lieberman',
2021,2,80000,11,'DVBKA.jpg',N'Read Anyone - Apply In Business gives you quick tools
quickly and effectively, showing you step-by-step, detailed, and careful how to build actionable strategies
in any situation. This is not just an idea, theory or trick that only works in a few situations
situation or with a few people, which really opens you up to an opportunity to use important psychological tools that help
Manipulate human behavior to gain the necessary advantage.Teacher of tactics to many senior negotiators in
government, he works with top mental health professionals and he is one of not many
training business managers of more than 25 countries worldwide.
There are many business books that provide you with rules, principles, strategies and stories. But here
is a book that provides detailed solutions to real problems. You will get clear benefits when
Read this book whether you are running a small, medium or large business. You will be safe knowing
what is really going on at all times, have the power to keep potentially dangerous situations at bay
never happens, and when necessary is the ability to overcome the most difficult situations in a way
fast and convenient. When the stakes are big, do more than simply bet on the door you like – put
Put your energy into the game to make sure you do not lose.
',1)
insert Book([name_Book],[author_Book],[year_Of_Public],[category],[price_Book],[quantity_Book],
[image],[description_Book],[status_Book])
values (N'Bá Tước Monte Cristo','Edmond Dantes',
2021,3,140000,5,'BT.jpg',N'
Count of Monte Cristo is not only excellent in plot, character building, climax
but also convey ideas about happiness, suffering, life philosophies and human values
Literature. This is the most unique and famous work of Alexandre Dumas, completed in
1844, about a young, talented sailor named Edmond Dantès.

Edmond is life is not rich, but happy because he has a dear old father, who has a good taste
beautiful fiancee, has a very kind owner...

The day he got married was the most tragic day of his life. Edmond was suddenly slandered, locked in
dungeon like a dangerous criminal. His lover suffers, his father dies without help
meet you... His life completely sank into the abyss of despair with no way out.

Thought Edmond would be buried in the dungeon, but thanks to a wise man
but being considered crazy, taught him everything wholeheartedly. 19 years of abstaining from bitterness,
Edmond escaped from prison and went in search of treasure. He secretly changed his name to Monte Cristo, started again
life with a plan to take revenge on all those who caused him tragedy in the past...',1)
insert Book([name_Book],[author_Book],[year_Of_Public],[category],[price_Book],[quantity_Book],
[image],[description_Book],[status_Book])
values (N'Chúa Tể Những Chiếc Nhẫn','J.R.R. Tolkien',
2021,4,210000,9,'CTCNCN.jpg',N'CHÚA TỂ NHỮNG CHIẾC NHẪN.
“The English community is divided into two: those who have read The Hobbit with the Lord
the rings, and who will read.” - Sunday Times
“Christians who have not finished reading the Bible can still pardon, but a petty fan
Fantasy theory without having read the gospel of this genre is unacceptable.”
- Amazon.com
“Tolkien was blessed with the gift of precise naming and a marvelous eye for observation; end
In book I, readers already know the history of Hobbits, Elves, Dwarves and their homeland
no less than knowing the country of his childhood. And if you take a fantasy story seriously
everyone has to see that despite the appearance of presenting characters and events so far apart
In the world we live in, it is still the only mirror of reality that we know: the reality of
we." - W. H. Auden',1)
insert Book([name_Book],[author_Book],[year_Of_Public],[category],[price_Book],[quantity_Book],
[image],[description_Book],[status_Book])
values (N'Ông già và biển cả','Ernest Hemingway',
2021,3,120000,13,'OGVBC.jpg',N'Ông Già Và Biển Cả
Set in a fishing village in La Habana, the work tells the story of his lonely battle
old Santiago with his mighty swordfish and ferocious sharks in the ocean. Plain
narrative voice and the art of constructing opposing subjects, Hemingway wrote a
multi-vocal, multi-faceted epic of wills and aspirations to conquer people is dreams before
cruel storm.
In Vietnam, The Old Man and the Sea was translated very early and there are many different translations.
In this edition, Dong A selected the translation of professor, translator Le Huy Bac, a writer
intensive research on American literature in general and on writer Hemingway in particular. This is the version
The translation has been reprinted many times and is included in the textbook curriculum.
At the same time, Dong A also adorns the new edition with illustrations by artist Le Tri, which is
Scratchboard inspired drawing.
SOME COMMENTS:
“I knew this would be the best piece I could write in my entire life.”
Hemingway is letter to editor Wallace Meyer
“The book gives you hope.”
The Guardian
“His greatest work [Hemingway].”
William Faulkner wrote and submitted to the literary magazine Shenandoah.',1)
insert Book([name_Book],[author_Book],[year_Of_Public],[category],[price_Book],[quantity_Book],
[image],[description_Book],[status_Book])
values (N'Thép đã cho tôi thế đấy','Nikolai A. Ostrovsky',
2021,3,120000,10,'TDCTTD.jpg',N'Đọc Thép đã cho tôi thế đấy First of all, it instills in us a thirst for life and a desire to fight.
Such was the class nature of Pavel. Such was the youthful nature of Pavel. That is the product
revolutionary quality that the Party and actual struggle have built for him. Not a flame of straw
the shock or the blasphemy of individual heroism. A spirit of lust and
the most meaningful fighting desire, the most grounded. Nothing is stronger than Paven is trust
in his combat purposes. Pavel was passionate about serving the people wholeheartedly, wholeheartedly,
his personal sacrifice in a passionately romantic way, without hesitation, without counting
math, all for the cause of the class, for the happiness of mankind. Do not understand the purpose of fighting
Pavel is party, Pavel is fighting party only felt that Pavel is life was miserable. No,
Pavel did not feel pain, only thought of overcoming suffering. Paven always
glad you always fight and always win. It is the optimism of
Paven. That was the strength, that was the happiness of Pavel.
Steel has hardened that is a beautiful song of life. Each page of the book is like a book with more blood
flowing in the reader, raising revolutionary enthusiasm, urging to fight, urging
go on bussiness.
This hardened steel solves many new problems for us, teaches us
know love and hate accurately and deeply, arouse in us great feelings,
build us a concept of pure love. Steel is already hardened, it is still one
a treasure trove of practical revolutionary work experience to shed light on many new issues
life is set out for each group and each person, to perform "any task will be completed".
success, every difficulty can be overcome, every enemy will win."',1)
insert Book([name_Book],[author_Book],[year_Of_Public],[category],[price_Book],[quantity_Book],
[image],[description_Book],[status_Book])
values (N'Số Đỏ',N'Vũ Trọng Phụng',
2020,3,304000,10,'SD.jpg',N'Số đỏ is Vu Trong Phung is most famous novel, and also a famous work
loved by readers for generations. The guy "Red Hair Spring" also became a character
"classic" "everyone knows" when referring to Vietnamese literature. From an orphan, fatherless
no mother, no home, no home, no education… a step into becoming a national hero, a grandfather
newspaper director, a person who plays an important role in the "Europeanized" society. Spring is life story
makes the reader very happy, laughs to tears, and also laughs to pity, to feel sorry for
alienation, the race for a time of the old society.
The novel has 20 parts, each part has a title for the content of that part. Repeat
Red numbers to laugh back with the smile of the old man, and also look back on the present life to live
better, more beautiful.
Red Number is one of the works that Live (Vietnamese author is book brand) specially selected
selected to be included in Khue Van Bookcase - a bookcase of wonderful literary works that are likened to
for the stars in Vietnamese literature.',1)
insert Book([name_Book],[author_Book],[year_Of_Public],[category],[price_Book],[quantity_Book],
[image],[description_Book],[status_Book])
values (N'Những Bậc Thầy Đổi Mới','Paul Sloane',
2022,2,140000,16,'NBTDM.jpg',N'“A refreshing, engaging adventure that delves into the hearts and minds of leaders
inspiring, believes in the limitless potential of human innovation and proves that with
With the right practice and encouragement, everyone has the capacity to innovate.” – Ajaz Ahmed,
Managing Director, AKQA
“To foster a spirit of innovation, you often need inspiration from others. This book gives
This is important to all of us.” Kim Pedersen, Executive Vice President of GEODIS
“Sloane proves that powerful innovation exists in all of us. This book is
a map to find it.” – Bill Penn, founder, Aspectus PR
“Have you ever wondered David Bowie, Soichiro Honda, William Shakespeare, Thomas Edison,
What do Steve Jobs, Dick Fosbury, Marie Curie and Elon Musk have in common? All of course
Both were innovators, but they approached innovation in completely different ways. Paul
Sloane provides insight into how they have used innovation to achieve things
excellent in their field. Perhaps you will be inspired to be innovative, bright
create more…” – Iain Bitran, CEO, ISPIM - International Association for Innovation Management
Professional.Paul Sloane is the UK is leading innovation speaker and founder of Destination Innovation, a blogger with over 30,000 followers on Twitter (@paulsloane). He is also the author of more than 20 books on leadership, innovation, critical thinking and problem solving.

He majored in Engineering at Cambridge University. He served as a brilliant salesman at IBM and later as a marketing director, chief executive officer, and CEO of software companies such as Ashton-Tate. He now lives with his family in Camberley, Surrey. ',1)
insert Book([name_Book],[author_Book],[year_Of_Public],[category],[price_Book],[quantity_Book],
[image],[description_Book],[status_Book])
values (N'Cảm Ơn Tất Cả','Kim Jung mi',
2022,1,90000,2,'CMTC.jpg',N'Also in Thank you all there is a pretty clear image of a Vietnamese woman – Thuy,
Yu Jung is aunt. Thuy 20 years old married a husband of different nationality 37 years old
from the first meeting but her marriage is quite happy. She and her husband love
love each other, have 3 children and integrate well into their new life. She appeared from the front page
the first part of the work in the somewhat harshly hostile gaze of the mother-in-law and niece and
also appeared in the last lines with a close and dear image: “When I was just sitting
on the chair, received a message. It is a message from my aunt. "You did not miss the car, did you?
High school girl Yu Jung, study hard! Love you!” I replied to your aunt is message.
“Auntie, thanks. I love you ”
The young people in the village learned to heal themselves and their present "now, here" lives and helped other adults heal their wounds. Yu Jung overcame guilt, low self-esteem, studied well and was obedient, filial to her grandmother and aunts and uncles. Kwang Su from a boy who is good at farming but neglects his studies after a summer vacation, works part-time at a restaurant with his mother who he has not met for a long time, has almost "transformed", studied hard and achieved outstanding results. to the surprise of teachers and friends. It is Yu Jung is kind uncle, a farmer who is determined to pursue a high-quality clean agriculture who has faced many failures and barriers and is still determined to overcome by all means...
After all, Kim Jung-mi is novel Thank You All gives the reader a glimpse
warm, compassionate about life and full of faith and love in the young people who are entering
A life full of beautiful dreams and ambitions.',1)
insert Book([name_Book],[author_Book],[year_Of_Public],[category],[price_Book],[quantity_Book],
[image],[description_Book],[status_Book])
values (N'Conan','Aoyama Gosho',
2022,1,20000,15,'conan.jpg',N'The work was serialized in Shogakukan Weekly Shōnen Sunday magazine in 1994 and has been 
packaged in 101 tankōbon volumes as of April 2022. The story revolves around a high school detective named Kudo Shinichi 
during is investigating a mysterious Black Organization that has been forced to drink a deadly poison. Fortunately, he survived,
but his body was shrunken like a 6-year-old child. Since then in order to avoid revealing his true identity, he took the name 
Edogawa Conan and moved in with his childhood friend Ran Mori house with her father, a private detective named Mori Kogoro. 
hopefully one day he can defeat the Black Organization and regain his original form.The manga inspired an anime television 
series by Yomiuri Telecasting Corporation and TMS Entertainment, which premiered in January 1996. It was followed by the anime
theme, OVA, video game, soundtrack, and live action film. Funimation licensed the anime series in North America in 2003 under
the title Case Closed with Americanized character names. The anime premiered on Adult Swim but ended soon due to low viewership
ratings. In March 2013, Funimation began streaming their licensed episodes; Crunchyroll co-streamed in 2014. Funimation also 
localized the first six films, while Discotek Media localized the crossover special with Lupine III, the sequel, and selected
recent films, starting with Meitantei Conan Episode One . Meanwhile, the manga was localized by Viz Media, using Funimation 
altered character names and titles. Shogakukan Asia made the English localization of the manga using the Japanese title and 
original Japanese title. In Vietnam, the anime series has been shown on HTV3 since December 2009 with a Vietnamese dub version.
',1)
/* Insert Book Request*/
/*date format: year-month-day '2021-2-7'*/

insert BookingRequest (image,name_Book,quantity_Request,price_Request,date_Request,date_Request_Done,note,status,status_Book_Request)
values ('BGCC.jpg',N'Bài Giảng Cuối Cùng',10,80000,'2022-10-1','2022-10-4',N'Sách có kèm quà lưu niệm',2,0)
insert BookingRequest (image,name_Book,quantity_Request,price_Request,date_Request,date_Request_Done,note,status,status_Book_Request)
values ('OGVBC.jpg',N'LOL',10,80000,'2022-10-1','2022-10-5',N'Sách có poster',1,1)

/* Insert Importation*/

insert Importation (employee_Id,date_Import,request_id)
values (2,'2022-10-1',1)

/* Insert Importation Detail*/

insert ImportationDetail([import_Id],quantity_Import_Detail,
[price_Import_Detail],[total_Import_Detail],[note],status,[book_Id])
values (1,10,80000,800000,'importation enough book',1,1)

/* Insert Invetory*/

insert Inventory (employee_Id,date_Into_Inventory)
values (2,'2022-9-28')

/* Insert Invetory detail*/

insert InventoryDetail ([inventory_Id],[book_Id],[quantity_Inventory],[note],status)
values (1,11,2,N'Book Lose Team',1)
insert InventoryDetail([inventory_Id],[book_Id],[quantity_Inventory],[note],status)
values (1,8,3,N'Book Lose Team',1)

/*Insert Order*/

insert [Order](employee_Id,date_To_Oder,quantity_Order,total_Order,status)
values (3,'2022-10-4',2,1068000,1)
insert [Order](employee_Id,date_To_Oder,quantity_Order,total_Order,status)
values (4,'2022-10-5',1,360000,1)

/*Insert Order Detail*/

insert OrderDetail([order_Id],[book_Id],[quantity_Order_Detail],[total_Order_Detail])
values (1,6,2,156000)
insert OrderDetail([order_Id],[book_Id],[quantity_Order_Detail],[total_Order_Detail])
values (1,4,5,912000)
insert OrderDetail([order_Id],[book_Id],[quantity_Order_Detail],[total_Order_Detail])
values (2,12,3,360000)