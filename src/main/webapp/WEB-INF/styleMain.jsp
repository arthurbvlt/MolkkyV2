<style>
@import url('https://fonts.googleapis.com/css2?family=Poppins:wght@300&display=swap');


/* 
    display: flex;
    align-items: center;
    justify-content: center;
    justify-items: center; */
*{
	box-sizing: border-box
}
body{
	margin: 5em 0em 0em 20em;
    text-align: center;
    font-family: 'Poppins', sans-serif;
    font-size: 30px;
    display: inline-block;
    min-height: 100vh;
    background-color: white;
}
#score{
	margin-left: 32px;
    margin-top: 49px;
}
.container{
}
input[name="score"] {
	text-align: center;
    width: 92px;
}

.button {
  color: white;
  background-color: black;
  border: 1px solid #ffffff;
  border-radius: 4em;
  font-size: 22px;
  padding: 7px 38px;
  cursor: pointer;
  transition: all 0.3s ease-in-out;
  margin-left: 10px;
}

.button:hover {
  transform: scale(1.1);
}
.bg1{
	padding: 10px;
    border-radius: 6px;	
}
.bg2{
	position: absolute;
	margin-left: 17em;
    top: 5em;
    border-radius: 6px;	
	padding: 10px 38px 10px 38px;
	z-index: -1;	
}

</style>