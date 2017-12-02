from rest_framework import serializers
from .models import *

class AppUserSerializer(serializers.ModelSerializer):
    class Meta:
        model = AppUser
        fields = ('name','email','age','photo','user_type')

    def create(self, validated_data):
        return AppUser.objects.create(**validated_data)

class LandSerializer(serializers.ModelSerializer):
    farmer = AppUserSerializer(many=False, read_only=True)  
  
    class Meta:
        model = Land
        fields = ('farmer', 'location', 'size', 'unit', 'duration')

    def create(self, validated_data):
    	return Land.objects.create(**validated_data)

class CropSerializer(serializers.ModelSerializer):
    crop_land = LandSerializer(many=False, read_only=True)

    class Meta: 
        model = Crop
        fields = ('crop_land', 'name', 'total_quantity', 'quantity_remaining')

    def create(self,validated_data):
        return Crop.objects.create(**validated_data)

class SharePurchaseSerializer(serializers.ModelSerializer):
    user = AppUserSerializer(many=False, read_only=True)
    
    class Meta: 
        model = SharePurchase
        fields = ('user', 'value', 'transaction_id')

    def create(self, validated_data):
        return SharePurchase.objects.create(**validated_data)

		
