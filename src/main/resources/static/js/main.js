

document.getElementById("btn").addEventListener("click",()=>{
    setInterval(()=>{
      document.getElementById("form").submit();
    },2000);
})

document.querySelectorAll(".name").forEach(target=>{
    target.addEventListener("keyup",()=>{
    let name = target.value
      if(name != ''){
        fetch("/api/v1/user/search/"+name,{
              method : 'GET',
              headers: {'Content-Type': 'application/json'}
            }).then(res => {
              if(res.ok){
                return res.json()
              }
            }).then(json => {  
              console.log(json);
              autocomplete(target, json);
            })
        }
    })
  })
  
  function autocomplete(inp, arr) {
    let currentFocus;
 
    let a, b, i, val = inp.value;
    
    closeAllLists();
    currentFocus = -1;
    a = document.createElement("div");
    
    a.setAttribute("id", this.id + "autocomplete-list");
    a.setAttribute("class", "autocomplete-items");
    

    inp.parentNode.appendChild(a);
    /*for each item in the array...*/
    for (i = 0; i < arr.length; i++) {
        b = document.createElement("div");
        b.innerHTML = "<strong>" + arr[i].substr(0, val.length) + "</strong>";
        b.innerHTML += arr[i].substr(val.length);
        b.innerHTML += "<input type='hidden' value='" + arr[i] + "'>";
        b.addEventListener("click", function(e) {
            inp.value = this.getElementsByTagName("input")[0].value;
            closeAllLists();
        });
        a.appendChild(b);
     }

    function addActive(x) {
      if (!x) return false;
      removeActive(x);
      if (currentFocus >= x.length) currentFocus = 0;
      if (currentFocus < 0) currentFocus = (x.length - 1);
      x[currentFocus].classList.add("autocomplete-active");
    }

    function removeActive(x) {
          for (let i = 0; i < x.length; i++) {
        x[i].classList.remove("autocomplete-active");
      }
    }

    function closeAllLists(elmnt) {
      let x = document.getElementsByClassName("autocomplete-items");
      for (let i = 0; i < x.length; i++) {
        if (elmnt != x[i] && elmnt != inp) {
        x[i].parentNode.removeChild(x[i]);
      }
    }
  }
  document.addEventListener("click", function (e) {
      closeAllLists(e.target);
  });
 }


