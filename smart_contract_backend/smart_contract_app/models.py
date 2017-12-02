from django.db import models
from django.contrib.auth.models import User;

class AppUser(models.Model):
    name = models.CharField(max_length=30)
    email = models.EmailField()
    password = models.CharField(max_length=30)
    age = models.IntegerField()
    id_proof = models.FileField(upload_to='id_proof/',
               blank=True)
    photo = models.FileField(upload_to='photos/',
            blank=True)
    FARMER = 'f'
    CONSUMER = 'u'
    USER_TYPE = (
        (FARMER, 'Farmer'),
        (CONSUMER, 'Consumer'),
    )
    user_type= models.CharField(
        max_length = 1,
        choices = USER_TYPE,
        default = CONSUMER,
    )
    shares = models.IntegerField(default=0)
 
    def __str__(self):
        return self.name 
   
class Land(models.Model):
    farmer = models.ForeignKey(AppUser) 
    location = models.CharField(max_length=30)
    size = models.IntegerField()
    SQUARE_METER = 'm2'
    SQUARE_KILOMETER = 'km2'
    HECTARE = 'he'
    UNITS_CHOICE = (
        (SQUARE_METER, 'm. sq'),
        (SQUARE_KILOMETER, 'km. sq'),
        (HECTARE, 'hectare'),
    )
    unit = models.CharField(
        max_length = 2,
        choices = UNITS_CHOICE,
        default = SQUARE_METER,
    )
    duration = models.IntegerField()
    def __str__(self):
        return self.farmer.name+" "+str(self.size)+str(self.unit)
 
class Crop(models.Model):
    crop_land = models.ForeignKey(Land)
    name = models.CharField(max_length=30)
    total_quantity = models.FloatField()
    quantity_remaining = models.FloatField()
    def __str__(self):
        return self.name  
    
class SharePurchase(models.Model):
    user = models.ForeignKey(User)
    value = models.IntegerField()
    transaction_id = models.CharField(max_length=32)
    def __str__(self):
        return self.user+" "+self.value
 
class CropPurchase(models.Model):
    crop = models.ForeignKey(Crop)
    user = models.ForeignKey(User)
    purchased_quantity = models.FloatField()
    purchase_value = models.FloatField()
    def __str__(self):
        return self.user.name+" "+self.crop.name 
 
