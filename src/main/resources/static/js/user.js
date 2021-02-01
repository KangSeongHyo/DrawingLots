function createUser() {
    let name = document.getElementById('uname').value;

    fetch("/api/v1/user",{
      method : 'POST',
      body : JSON.stringify({name}),
      headers: {'Content-Type': 'application/json'}
    }).then(res => {
      if(res.ok){
        document.location = "/"
      }else{
        return res.json()
      }
    }).then(json => {  
      if(json.errCode == 'DUP'){
        alert("중복되는 이름입니다.");
      }else{
        alert('오류가 발생하였습니다. ['+res.status+']');
      }
    })
  }