package com.example.hexagonal.application.user.port.out

interface UserPort :
        FindUserPort,
        ExistUserPort,
        SaveUserPort