<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Instructor List</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body>
<div id="app">
    <div class="h-full bg-gray-100">
        <div class="relative bg-gray-900">
            <header class="relative z-10">
                <nav class="bg-white shadow">
                    <div class="mx-auto max-w-7xl px-4 sm:px-6 lg:px-8">
                        <div class="flex h-16 justify-between">
                            <div class="flex">
                                <a href="/" class="flex flex-shrink-0 items-center">
                                    <img class="h-12 w-auto" src="/images/logo.png" alt="Logo">
                                </a>
                            </div>
                            <div class="ml-6 flex space-x-8">
                                <a href="/students" class="inline-flex items-center border-b-2 border-transparent px-1 pt-1 text-sm font-medium text-gray-700 hover:border-gray-300 hover:text-gray-700">Students</a>
                                <a href="/instructors" class="inline-flex items-center border-b-2 border-indigo-500 px-1 pt-1 text-sm font-medium text-gray-900">Instructors</a>
                                <a href="/vehicles" class="inline-flex items-center border-b-2 border-transparent px-1 pt-1 text-sm font-medium text-gray-700 hover:border-gray-300 hover:text-gray-700">Vehicles</a>
                                <a href="/schedules" class="inline-flex items-center border-b-2 border-transparent px-1 pt-1 text-sm font-medium text-gray-700 hover:border-gray-300 hover:text-gray-700">Schedules</a>
                                <a href="/payments" class="inline-flex items-center border-b-2 border-transparent px-1 pt-1 text-sm font-medium text-gray-700 hover:border-gray-300 hover:text-gray-700">Payments</a>
                            </div>
                        </div>
                    </div>
                </nav>
            </header>
        </div>

        <div class="mx-auto max-w-7xl p-12 px-16">
            <div class="sm:flex sm:items-center">
                <div class="sm:flex-auto">
                    <h1 class="text-base font-semibold leading-6 text-gray-900">Instructor List</h1>
                    <p class="mt-2 text-sm text-gray-700">A list of all instructors including their ID, name, age, phone, address, and specialization.</p>
                </div>
                <div class="mt-4 sm:ml-16 sm:mt-0 sm:flex-none">
                    <a href="/instructors/add-instructor" class="block rounded-md bg-indigo-600 px-3 py-2 text-center text-sm font-semibold text-white shadow-sm hover:bg-indigo-500 focus-visible:outline focus-visible:outline-2 focus-visible:outline-offset-2 focus-visible:outline-indigo-600">Add Instructor</a>
                </div>
            </div>

            <div class="mt-8 flow-root">
                <div class="-mx-4 -my-2 overflow-x-auto sm:-mx-6 lg:-mx-8">
                    <div class="inline-block min-w-full py-2 align-middle sm:px-6 lg:px-8">
                        <table class="min-w-full divide-y divide-gray-300 border border-gray-300">
                            <thead>
                            <tr class="divide-x divide-gray-200">
                                <th class="px-4 py-3.5 text-left text-sm font-semibold text-gray-900">ID</th>
                                <th class="px-4 py-3.5 text-left text-sm font-semibold text-gray-900">Name</th>
                                <th class="px-4 py-3.5 text-left text-sm font-semibold text-gray-900">Age</th>
                                <th class="px-4 py-3.5 text-left text-sm font-semibold text-gray-900">Phone</th>
                                <th class="px-4 py-3.5 text-left text-sm font-semibold text-gray-900">Address</th>
                                <th class="px-4 py-3.5 text-left text-sm font-semibold text-gray-900">Specialization</th>
                                <th class="px-4 py-3.5 text-left text-sm font-semibold text-gray-900">Actions</th>
                            </tr>
                            </thead>
                            <tbody class="divide-y divide-gray-200 bg-white">
                            <c:forEach var="instructor" items="${instructors}">
                                <tr class="divide-x divide-gray-200">
                                    <td class="whitespace-nowrap p-4 text-sm font-medium text-gray-900">${instructor.id}</td>
                                    <td class="whitespace-nowrap p-4 text-sm text-gray-700">${instructor.name}</td>
                                    <td class="whitespace-nowrap p-4 text-sm text-gray-700">${instructor.age}</td>
                                    <td class="whitespace-nowrap p-4 text-sm text-gray-700">${instructor.phone}</td>
                                    <td class="p-4 text-sm text-gray-700">${instructor.address}</td>
                                    <td class="p-4 text-sm text-gray-700">${instructor.specialization}</td>
                                    <td class="whitespace-nowrap p-4 text-sm text-indigo-600 space-x-4">
                                        <a href="/instructors/edit-instructor/${instructor.id}" class="hover:underline">Update</a>
                                        <a href="/instructors/delete-instructor/${instructor.id}" class="hover:underline text-red-600">Delete</a>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>