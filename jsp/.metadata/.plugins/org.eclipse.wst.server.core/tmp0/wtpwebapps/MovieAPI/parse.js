const inner = document.querySelector(".inner");


const reqHeader = new Headers();
reqHeader.append("Content-Type", "application/json");
reqHeader.append("X-Naver-Client-Id", "Kyfh22pzlli_1dQYrgkl");
reqHeader.append("X-Naver-Client-Secret", "rWZw6ljF9q");

for(const item of reqHeader){
	  console.log(item)
	}
fetch('https://openapi.naver.com/v1/search/movie.json?query=%EC%A3%BC%EC%8B%9D&display=10&start=1&genre=1')
.then(res => {
  // response 처리
  console.log(res);
  // 응답을 JSON 형태로 파싱
  return res.json();
})
.then(data => {
  // json 출력
  console.log(data)
  
})
.catch(err => {
  // error 처리
  console.log('Fetch Error', err);
});