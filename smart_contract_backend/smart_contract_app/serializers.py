from rest_framework import serializers
from .models import *

class AppUserSerializer(serializers.ModelSerializer):
    class Meta:
        model = AppUser
        fields = ('name','email','age','photo','user_type')

    def create(self, validated_data):
        return AppUser.objects.create(**validated_data)

class CropSerializer(serializers.ModelSerializer):

    class Meta: 
        model = Crop
        fields = ('crop_land', 'name', 'total_quantity', 'quantity_remaining')


class LandSerializer(serializers.ModelSerializer):
    crops = CropSerializer(many=True, read_only=True)  
  
    class Meta:
        model = Land
        fields = ('crops' ,'farmer', 'location', 'size', 'unit', 'duration')

    def create(self, validated_data):
    	return Land.objects.create(**validated_data)

    def create(self,validated_data):
        return Crop.objects.create(**validated_data)


class FarmerSerializer(serializers.ModelSerializer):
    land = LandSerializer(many=True, read_only=True)

    class Meta: 
        model = AppUser
        fields = ('name','email','age','photo','user_type','land')

class SharePurchaseSerializer(serializers.ModelSerializer):
    user = AppUserSerializer(many=False, read_only=True)
    
    class Meta: 
        model = SharePurchase
        fields = ('user', 'value', 'transaction_id')

    def create(self, validated_data):
        return SharePurchase.objects.create(**validated_data)

class CropPurchaseSerializer(serializers.ModelSerializer):
    crop = CropSerializer(many=False, read_only=True)
    user = AppUserSerializer(many=False, read_only=True)

    class Meta:
        model = CropPurchase
        fields = ('crop','user','purchased_quantity')

    def create(self, validated_data):
        return CropPurchase.objects.create(**validated_data)		
