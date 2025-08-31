# [Gold V] ㄷ 만들기 - 23562 

[문제 링크](https://www.acmicpc.net/problem/23562) 

### 성능 요약

메모리: 14240 KB, 시간: 128 ms

### 분류

구현, 브루트포스 알고리즘

### 제출 일자

2025년 8월 31일 23:21:30

### 문제 설명

<p>2021년, 냅다 ㄷ 만들기는 한국인의 기본 소양이 되었다. 우리는 앞에 놓여있는 $n \times m$ 모눈종이에 냅다 ㄷ을 그리려 한다.</p>

<p>ㄷ 모양은 $k \times k$ 정사각형 7개를 붙인 형태로 정의한다. 다음은 각각 $k=1, k=2$일 때의 ㄷ 모양이다.</p>

<p style="text-align: center;"><img alt="" src="https://upload.acmicpc.net/fa6509c8-3f03-4b51-8c4e-350dd7011d72/-/preview/"></p>

<p>ㄷ 모양이 아닌 것의 예는 다음과 같다.</p>

<table align="center" border="1" cellpadding="1" cellspacing="1" class="table table-bordered" style="width: 500px;">
	<tbody>
		<tr>
			<td style="text-align: center; vertical-align: middle;"><img alt="" src="https://upload.acmicpc.net/d5044050-ccd7-4c93-92e5-05a2b52fb707/-/preview/"></td>
			<td style="text-align: center; vertical-align: middle;"><img alt="" src="https://upload.acmicpc.net/25a258e1-5461-4048-a7fb-bd0d7caac079/-/preview/"></td>
		</tr>
		<tr>
			<td style="text-align: center;">7개의 $k \times k$ 정사각형으로 이루어지지 않음</td>
			<td style="text-align: center;">ㄷ 모양을 뒤집거나 돌릴 수는 없음</td>
		</tr>
	</tbody>
</table>

<p>모눈종이의 일부 칸에는 이미 검은색이 칠해져 있다. 흰색 칸을 검은색으로 칠하는 데 드는 비용은 $a$, 검은색 칸을 지워서 흰색 칸으로 만드는 데 드는 비용은 $b$다. 검은색 칸들이 ㄷ 모양을 이룰 수 있도록 하기 위해 드는 최소 비용을 구하는 프로그램을 작성하자.</p>

<p>ㄷ 모양의 위치와 크기에는 제한이 없지만, 뒤집거나 돌릴 수는 없으며, 모눈종이를 벗어나도 안 된다. 또한, 모든 검은색 칸은 ㄷ 모양에 포함되어야 하고, ㄷ 모양에 포함되지 않는 칸은 모두 흰색이어야 한다.</p>

### 입력 

 <p>첫 번째 줄에 모눈종이의 크기 $n, m$이 주어진다.</p>

<p>두 번째 줄에 칸의 색깔을 바꾸는 데 드는 비용 $a,b$가 주어진다.</p>

<p>다음 $n$개의 줄에 길이 $m$인 문자열이 주어진다. <code>#</code>은 검은색으로 칠해진 칸, <code>.</code>은 흰색 칸을 의미한다.</p>

### 출력 

 <p>첫 번째 줄에 ㄷ 모양을 만들 수 있는 최소 비용을 출력한다.</p>

