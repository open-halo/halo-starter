
目前 Hibernate还不支持record作为Entity，所以不建议定义为record
model模块中建议定义领域建模的核心模型  
（1）如果为了省去mapstruct的转换，可以通过注解定义一个JPA的entity
（2）如果为了model层的纯净，可以不使用注解，后续使用mapstruct转化到entity

book---N:1---author
book---N:M---store