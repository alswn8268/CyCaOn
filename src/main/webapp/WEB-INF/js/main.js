function openProfile(fid, mid) {
	let url = 'profile?fid=' + fid + '&mid=' + mid;
	let title = '프로필 보기';
	let option = 'top=40%, left=40%, width=800px, height=800px';
	window.open(url, title, option);
}

function goChat(nickname) {
	let chatContent = document.getElementsByName('chatContent')[0].value;
	let roomIdx = document.getElementById('roomIdx').value;
	
	$.ajax({
		type: 'POST',
		url: 'goChat',
		data: {
			chatContent: chatContent,
			chatNickname: nickname,
			chatRoomIdx: roomIdx,
		},
		success: res => {
			console.log('요청 성공: ', res);
	
			let object = eval('(' + res + ')');
			let result = object.result;
			console.log(result);			
			
//
//			// 서블릿에서 수신된 데이터를 출력하기 위해 <tbody> 태그를 얻어온다.
//			let tbody = document.getElementById('ajaxTable');
//			// 새로 검색되는 데이터가 표시되어야 하므로 이전에 <tbody> 태그에 들어있던 내용은 지운다.
//			tbody.innerHTML = '';
//			
//			// 데이터의 개수만큼 반복하며 <tbody>에 행을 만들어 추가한다.
//			for (let i=0; i<result.length; i++) {
//				// <tbody>에 넣어줄 행을 만든다.
//				let row = tbody.insertRow(i);
//				// 한 행에 출력할 열의 개수만큼 반복하며 행에 열을 추가한다.
//				for (let j=0; j<result[i].length; j++) {
//					// 행에 넣어줄 열을 만든다.
//					let cell = row.insertCell(j);
//					// 열에 화면에 표시할 데이터를 넣어준다.
//					cell.innerHTML = result[i][j].value;
//				}
//			}
			
			
			
			
		},
		error: e => {
			console.log('요청 실패: ', e);
		}
	});
	
}

function modalClose() {
	var modal = document.getElementById('wantFModal');
	modal.style.display = 'none';
}

function changeInfo() {
	var id = document.getElementById('id').value;
	var nickname = document.getElementById('nickname').value;
	var password = document.getElementById('password').value;
	var introduce = document.getElementById('introduce').value;
	
	location.href='changeInfo?nickname=' + nickname + '&password=' + password + '&id=' + id + '&introduce=' + introduce;
}

function isPwd() {
	var chkpwd = document.getElementById('chkpwd').value
	var password = document.getElementById('roompwd');
	var roompwdinput = document.getElementById('roompwdinput')
	
	if (chkpwd == '없음') {
		roompwdinput.innerHTML = '';
	} else if (chkpwd == '있음') {
		roompwdinput.innerHTML = '<input type="password" id="roompwd" placeholder="비밀번호를 입력해주세요" name="roomPassword">';
	}
	
}

function addTodo() {
	var todo = document.getElementById('todo').value;
	var id = document.getElementById('id').value;
	
	$.ajax({
		type: 'POST',
		url: 'addTodo',
		data: {
			todo : todo,
			id : id
		},
		success: res => {
			console.log('요청 성공: ', res);
		},
		error: e => {
			console.log('요청 실패: ', e);
		}
	});	
	
}


