<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Instructor</title>
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

        <div class="mx-auto max-w-7xl p-12 px-16">
            <div class="bg-gray-100 flex flex-col pt-4">
                <div class="space-y-10 divide-y divide-gray-900/10">
                    <div class="grid grid-cols-1 gap-x-8 gap-y-8 md:grid-cols-3">
                        <div class="px-4 sm:px-0">
                            <h2 class="text-base font-semibold leading-7 text-gray-900">Add New Instructor</h2>
                            <p class="mt-1 text-sm leading-6 text-gray-600">Fill in the details to add a new instructor.</p>
                        </div>

                        <form action="add-instructor" method="POST" class="bg-white shadow-sm ring-1 ring-gray-900/5 sm:rounded-xl md:col-span-2">
                            <div class="px-4 py-6 sm:p-8">
                                <div class="grid max-w-2xl grid-cols-1 gap-x-6 gap-y-8 sm:grid-cols-6">
                                    <div class="sm:col-span-3">
                                        <label for="name" class="block text-sm font-medium leading-6 text-gray-900">Name</label>
                                        <div class="mt-2">
                                            <input type="text" name="name" id="name" required class="block w-full rounded-md border-0 bg-white px-3 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm">
                                        </div>
                                    </div>

                                    <div class="sm:col-span-3">
                                        <label for="age" class="block text-sm font-medium leading-6 text-gray-900">Age</label>
                                        <div class="mt-2">
                                            <input type="number" name="age" id="age" required class="block w-full rounded-md border-0 bg-white px-3 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm">
                                        </div>
                                    </div>

                                    <div class="sm:col-span-3">
                                        <label for="phone" class="block text-sm font-medium leading-6 text-gray-900">Phone</label>
                                        <div class="mt-2">
                                            <input type="text" name="phone" id="phone" required class="block w-full rounded-md border-0 bg-white px-3 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm">
                                        </div>
                                    </div>

                                    <div class="sm:col-span-3">
                                        <label for="specialization" class="block text-sm font-medium leading-6 text-gray-900">Specialization</label>
                                        <div class="mt-2">
                                            <input type="text" name="specialization" id="specialization" required class="block w-full rounded-md border-0 bg-white px-3 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm">
                                        </div>
                                    </div>

                                    <div class="col-span-full">
                                        <label for="address" class="block text-sm font-medium leading-6 text-gray-900">Address</label>
                                        <div class="mt-2">
                                            <input type="text" name="address" id="address" required class="block w-full rounded-md border-0 bg-white px-3 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm">
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="flex items-center justify-end gap-x-6 border-t border-gray-900/10 px-4 py-4 sm:px-8">
                                <a href="/instructors" class="text-sm font-semibold leading-6 text-gray-900">Cancel</a>
                                <button type="submit" class="rounded-md bg-indigo-600 px-3 py-2 text-sm font-semibold text-white shadow-sm hover:bg-indigo-500 focus-visible:outline-2 focus-visible:outline-offset-2 focus-visible:outline-indigo-600">Add Instructor</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>