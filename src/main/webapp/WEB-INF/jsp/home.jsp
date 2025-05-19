<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html class="h-full">
<head>
    <title>Driving School Management System</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="h-full">
<div id="app" class="min-h-full">
    <div class="min-h-screen bg-gray-100">
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
                                <a href="/instructors" class="inline-flex items-center border-b-2 border-transparent px-1 pt-1 text-sm font-medium text-gray-700 hover:border-gray-300 hover:text-gray-700">Instructors</a>
                                <a href="/vehicles" class="inline-flex items-center border-b-2 border-transparent px-1 pt-1 text-sm font-medium text-gray-700 hover:border-gray-300 hover:text-gray-700">Vehicles</a>
                                <a href="/schedules" class="inline-flex items-center border-b-2 border-transparent px-1 pt-1 text-sm font-medium text-gray-700 hover:border-gray-300 hover:text-gray-700">Schedules</a>
                                <a href="/payments" class="inline-flex items-center border-b-2 border-transparent px-1 pt-1 text-sm font-medium text-gray-700 hover:border-gray-300 hover:text-gray-700">Payments</a>
                            </div>
                        </div>
                    </div>
                </nav>
            </header>
        </div>

        <main class="mx-auto max-w-7xl px-4 sm:px-6 lg:px-8">
            <div class="py-16">
                <div class="text-center">
                    <h1 class="text-4xl font-bold tracking-tight text-gray-900 sm:text-6xl">Driving School Management System</h1>
                </div>

                <div class="mt-16 grid grid-cols-1 gap-8 sm:grid-cols-2 lg:grid-cols-3">
                    <div class="bg-white overflow-hidden shadow rounded-lg">
                        <div class="p-6">
                            <h3 class="text-xl font-semibold text-gray-900 mb-2">Students</h3>
                            <p class="text-gray-500 mb-4">Manage student registrations, track progress, and handle student information.</p>
                            <a href="/students" class="text-indigo-600 hover:text-indigo-500">View students &rarr;</a>
                        </div>
                    </div>

                    <div class="bg-white overflow-hidden shadow rounded-lg">
                        <div class="p-6">
                            <h3 class="text-xl font-semibold text-gray-900 mb-2">Instructors</h3>
                            <p class="text-gray-500 mb-4">Manage instructor profiles, specializations, and assignments.</p>
                            <a href="/instructors" class="text-indigo-600 hover:text-indigo-500">View instructors &rarr;</a>
                        </div>
                    </div>

                    <div class="bg-white overflow-hidden shadow rounded-lg">
                        <div class="p-6">
                            <h3 class="text-xl font-semibold text-gray-900 mb-2">Vehicles</h3>
                            <p class="text-gray-500 mb-4">Track vehicle inventory, maintenance, and availability.</p>
                            <a href="/vehicles" class="text-indigo-600 hover:text-indigo-500">View vehicles &rarr;</a>
                        </div>
                    </div>

                    <div class="bg-white overflow-hidden shadow rounded-lg">
                        <div class="p-6">
                            <h3 class="text-xl font-semibold text-gray-900 mb-2">Schedules</h3>
                            <p class="text-gray-500 mb-4">Manage lesson schedules, appointments, and calendar.</p>
                            <a href="/schedules" class="text-indigo-600 hover:text-indigo-500">View schedules &rarr;</a>
                        </div>
                    </div>

                    <div class="bg-white overflow-hidden shadow rounded-lg">
                        <div class="p-6">
                            <h3 class="text-xl font-semibold text-gray-900 mb-2">Payments</h3>
                            <p class="text-gray-500 mb-4">Track payments, generate invoices, and manage fees.</p>
                            <a href="/payments" class="text-indigo-600 hover:text-indigo-500">View payments &rarr;</a>
                        </div>
                    </div>
                </div>
            </div>
        </main>
    </div>
</div>
</body>
</html>