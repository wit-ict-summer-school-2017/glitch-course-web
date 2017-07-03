const goMark = 
  {
    url: "http://www.wit.ie",
    description: "third level educational institution",
    rating: 3,
    brenda: 1995,
  };


//

if("url" in goMark) { console.log(goMark.url +" => url"  )};

//
if("brenda" in goMark) {console.log("Brenda " + goMark.brenda)};


//

const playList = 
  {
    id: "01",
    title: "Beethoven Sonatas",
    artist: "Beethoven",
    songs: [ "Piano Sonata No. 3","Piano Sonata No. 7","Piano Sonata No. 10"],
    rating: 4
  };

//1.  Write the command to add the song "Paino Sonata 13" to the end of the songs array.

playList.songs.push("Piano Sonata No. 13");

//2.  Change the rating to the value of `7`.

playList.rating = 7;

//3.  Using the `delete` keyword, write the command to remove the artist key from the playList object.

delete playList.artist; 

//4.  Write the command to add a new key called `oldSchool` and a value of `true` to the playList object.
playList.oldSchool = true;

//5.  Using a loop, iterate through the songs array and console.log all of the songs.
for(let i=0; i<playList.songs.length; i++)
{
  console.log(playList.songs[i]);
}

//6.  Using a loop, console.log all of the keys in the playList object.
for(let singleKey in playList)
{
  console.log(singleKey);
}

//7.  Using a loop, console.log all of the values in the playList object.

for(let singleKey in playList)
{
  console.log(playList[singleKey]);
}
