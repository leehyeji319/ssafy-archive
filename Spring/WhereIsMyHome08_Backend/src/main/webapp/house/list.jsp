<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
    <section id="house-list" style="display:none">
      <div class="container h-auto">
        <div class="row" style="height: 700px; border: 1px solid">
        
          <div class="col" style="overflow: scroll; height: 100%;" >
            <div>
            	<div id="house-list-title">
              		<h1 class="h1">거래 정보</h1>
            	</div>
         
              <div>
              	<ul id="house-list-ul">
              	<!-- 
              			<li>
              			 	<div class="house-item">
			                  <div class="house-item-value house-item-name">${house.aptName}</div>
			                  <div class="house-item-value house-item-price">거래금액: ${house.dealAmount}만원</div>
			                  <div class="house-item-value house-item-area">면적: ${house.area}</div>
			                  <div class="house-item-value house-item-date">거래일: ${house.dealYear}.${house.dealMonth}.${house.dealDay}</div>
			                </div>
              			</li>
              			 -->
              	</ul>
               
              </div>
            </div>
          </div>
          
          <div class="col h-auto">
            <div id="map" style="width: 800px; height: 100%"></div>
          </div>
          
        </div>
      </div>
    </section>