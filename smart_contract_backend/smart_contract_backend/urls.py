"""smart_contract_backend URL Configuration

The `urlpatterns` list routes URLs to views. For more information please see:
    https://docs.djangoproject.com/en/1.11/topics/http/urls/
Examples:
Function views
    1. Add an import:  from my_app import views
    2. Add a URL to urlpatterns:  url(r'^$', views.home, name='home')
Class-based views
    1. Add an import:  from other_app.views import Home
    2. Add a URL to urlpatterns:  url(r'^$', Home.as_view(), name='home')
Including another URLconf
    1. Import the include() function: from django.conf.urls import url, include
    2. Add a URL to urlpatterns:  url(r'^blog/', include('blog.urls'))
"""
from django.conf.urls import url
from django.contrib import admin
from smart_contract_app import views

urlpatterns = [
    url(r'^admin/', admin.site.urls),
    url(r'^farmer/', views.AppUserList.as_view()),
    url(r'^farmer/(?P<pk>[0-9]+)/$', views.FarmerDetail.as_view(), 
    name='farmer-detail'),
    url(r'^crop_purchase/',views.CropPurchaseList.as_view()),
    url(r'^user_share/(?P<pk>[0-9]+)/$', views.UserShare.as_view(),
    name='user_share_detail'),
    url(r'^crops/', views.CropList.as_view()),
    url(r'^share/', views.SharePurchaseList.as_view()),    
]
