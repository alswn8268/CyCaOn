function openProfile(fid, mid) {
	let url = 'profile?fid=' + fid + '&mid=' + mid;
	let title = '프로필 보기';
	let option = 'top=40%, left=40%, width=800px, height=800px';
	window.open(url, title, option);
}

function goChat(nickname) {
	let chatContent = document.getElementsByName('chatContent')[0].value;
	let roomIdx = document.getElementById('roomIdx').value;
	let tbody = document.getElementById('chatTable');
	tbody.innerHTML = '';
	
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
			console.log(result)
			
			
			for (let i=0; i<result.length; i++) {
				let row = tbody.insertRow(i);
				for (let j=0; j<result[i].length; j++) {
					let cell = row.insertCell(j);
					if (j==0) {
						cell.innerHTML = result[i][j].value + '<br/>';						
					} else {
						cell.innerHTML = result[i][j].value;
					}
				}
			}			
			
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

function roomView(roomHost) {

	
	location.href='roomView?id=' + roomHost;
}
