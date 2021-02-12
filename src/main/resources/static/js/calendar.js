
document.getElementById("next").addEventListener("click",()=>{
    dateChecker("next");
});
document.getElementById("prev").addEventListener("click",()=>{
    dateChecker("prev");
});

function dateChecker(type) { 
    let year = document.getElementById("year").textContent*1;
    let month = document.getElementById("month").value*1;
    if(type === 'next'){
            if(month==12){
                month=1;
                year+=1;
            }else{
                month+=1;
            }  
    }else{
            if(month==1){
                month=12;
                year-=1;
            }else{
                month-=1;
            }  
    }
    location.href="/calendar?year="+ year +"&month="+ month;
}