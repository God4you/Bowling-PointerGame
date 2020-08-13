const api_url = "http://13.74.31.101/api/points"; //Api url with endpoint from skat

//Retrieve data from the api_url and showcases it
async function getPoints() {
  const response = await fetch(api_url); //fecting the data from api
  const data = await response.json(); //convert into JSON.
  const { points } = data; //destruct the data into "points" variabel.
  document.getElementById("table_data").textContent = points; //redisplay into element on the webpage.
}
getPoints();
