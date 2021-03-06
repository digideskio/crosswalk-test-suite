/*
Copyright (c) 2015 Intel Corporation.

Redistribution and use in source and binary forms, with or without modification,
are permitted provided that the following conditions are met:

* Redistributions of works must retain the original copyright notice, this list
  of conditions and the following disclaimer.
* Redistributions in binary form must reproduce the original copyright notice,
  this list of conditions and the following disclaimer in the documentation
  and/or other materials provided with the distribution.
* Neither the name of Intel Corporation nor the names of its contributors
  may be used to endorse or promote products derived from this work without
  specific prior written permission.

THIS SOFTWARE IS PROVIDED BY INTEL CORPORATION "AS IS"
AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
ARE DISCLAIMED. IN NO EVENT SHALL INTEL CORPORATION BE LIABLE FOR ANY DIRECT,
INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING,
BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY
OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE,
EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.

Authors:
        Wang, Hongjuan <hongjuanx.wang@intel.com>

*/

$(document).ready(function () {

  //LocalStorage
  $("#setLocalstorage").click(function(){
    msg = "test";
    localStorage.setItem("1", msg);
    $('#testDiv').text($('#testDiv').text() + '\nSave localStorage value successfully: ' + msg);
  })

  $("#getLocalstorage").click(function(){
    var msg = localStorage.getItem("1");
    if(msg == null){
      $('#testDiv').text($('#testDiv').text() + '\nPlease click "Set localStorage" at first');
    }
    else{
      $('#testDiv').text($('#testDiv').text() + '\nGet localStorage value: ' + msg);
    }
      
  })

  $("#clearLocalstorage").click(function(){
    var msg = localStorage.getItem("1");
    if(msg && msg != null) {
      localStorage.clear()
      $('#testDiv').text($('#testDiv').text() + '\nClear all localStorage value');
    }
    else {
      $('#testDiv').text($('#testDiv').text() + '\nNo localStorage can be cleared');
    }
  })
})
