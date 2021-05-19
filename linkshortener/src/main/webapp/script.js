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
    urlstring.trim();
    if(!(urlstring.startsWith("https://") ||urlstring.startsWith("http://"))){
        urlstring = "http://" + urlstring 
    }
    
    let url = `http://${urlhost}/linkshortener/createurl?url=${encodeURIComponent(urlstring)}`;
  console.log(url);

  let data = await fetch(url)
    .then((res) => res.json())
    .then((data) => {
      console.log(data);
      return data
    });

    if(data!= undefined){
        let output = document.getElementById("output")
        let url = `http://${urlhost}/linkshortener/r?q=${data.shortend}`
        output.innerHTML = `<a href="${url}">${url}</a>`
    }else{
        console.error("ERROR");
    }

}