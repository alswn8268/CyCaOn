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
			chatRoomIdx: roomIdx
		},
		success: res => {
			console.log('요청 성공: ', res);
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
	
	location.href='changeInfo?nickname=' + nickname + '&password=' + password + '&id=' + id;
}

function isPwd() {
	var chkpwd = document.getElementById('chkpwd').value;
	var password = document.getElementById('roompwd');
	
	if (chkpwd == '없음') {
		password.style.display = 'none';
	} else if (chkpwd == '있음') {
		password.style.display = 'inline';		
	}
	
}

