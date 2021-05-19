var urlhost = window.location.host;
var urlinput = document.getElementById("urlinput")

urlinput.addEventListener("keypress",(e) =>{

    if(e.key == "Enter"){
        console.log("Enter");
        inputfunc()
    }
});
document.getElementById("buttonid").addEventListener("click", (e) => {
    console.log("click");
    inputfunc()
})





async function inputfunc(){


    let urlstring = urlinput.value

    console.log("Input Function");
    
    
    let url = `http://${urlhost}/linkshortener/createurl?url=${encodeURIComponent(urlstring)}`;
  console.log(url);

  let temp = await fetch(url)
    .then((res) => res.json())
    .then((data) => {
      console.log(data);
    });
}