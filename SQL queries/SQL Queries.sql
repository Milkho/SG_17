/*Знайдіть імена (name) всіх працівників (employees), зарплата (salary) яких більша за керівника (boss).*/

SELECT
	Employees.Name
FROM
	Employees,
	(SELECT
		Employees.EmployeeID,
		Employees.Salary
	FROM
		Employees
	) AS SalaryInfo

WHERE Employees.BossID = SalaryInfo.EmployeeID
	AND Employees.Salary > SalaryInfo.Salary
	
	
/*Знайдіть працівників, котрі мають найбільшу зарплатню в своєму підрозділі (department).*/

SELECT
	Employees.*
FROM
	Employees
INNER JOIN Departments ON Employees.DepartmentID = Departments.DepartmentID
WHERE 
	Employees.Salary = (SELECT
							MAX (Employees.Salary) 
						FROM 
							Employees
						WHERE
							Employees.DepartmentID = Departments.DepartmentID)
ORDER BY 
	Employees.DepartmentID
	
	
/*Знайдіть назви всіх підрозділи, котрі мають менш ніж 3-х працівників/

SELECT
	Departments.Name
FROM 
	Departments
INNER JOIN Employees ON Departments.DepartmentID = Employees.DepartmentID
GROUP BY Departments.Name
HAVING COUNT(Employees.EmployeeID) < 3


/*Знайдіть працівників, котрі не бають керівників в своєму підрозділі*/

SELECT
	Employees.Name, 
	Departments.Name
FROM
	Employees
INNER JOIN Departments ON Employees.DepartmentID = Departments.DepartmentID
WHERE
	Employees.BossID IS NULL
	

/*Знайдіть котру загальну суму зарплатні отримує кожен підрозділ*/

SELECT
	Departments.DepartmentID,
	SUM(Employees.Salary)
FROM
	Employees
INNER JOIN Departments ON Employees.DepartmentID = Departments.DepartmentID
GROUP BY Departments.DepartmentID
