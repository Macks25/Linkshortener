document.getElementById("urlinput").addEventListener("keypress",(e) =>{

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
    console.log("Input Function");
}