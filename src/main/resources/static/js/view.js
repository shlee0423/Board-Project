const csrfToken = document.querySelector('meta[name="_csrf"]').getAttribute('content');

function deleteBoard(no){
    if (confirm("삭제하시겠습니까?")){
        fetch(`/board/${no}/delete`, {
            method: 'DELETE',
            headers: {
                'X-CSRF-TOKEN': csrfToken
            }
        })
            .then(response => {
                if (response.ok){
                    alert("삭제되었습니다.");
                    window.location.href = '/board';
                }else{
                    alert("삭제 실패");
                }
            })
            .catch(error => {
                alert("삭제 중 오류 발생" + error);
            })
    }
}