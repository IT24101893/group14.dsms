<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Edit Schedule</title>
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
                                <a href="/schedules" class="inline-flex items-center border-b-2 border-indigo-500 px-1 pt-1 text-sm font-medium text-gray-900">Schedules</a>
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
                            <h2 class="text-base font-semibold leading-7 text-gray-900">Edit Schedule</h2>
                            <p class="mt-1 text-sm leading-6 text-gray-600">Update the schedule details and click save.</p>
                        </div>

                        <form action="/schedules/edit-schedule/${schedule.lessonId}" method="POST" class="bg-white shadow-sm ring-1 ring-gray-900/5 sm:rounded-xl md:col-span-2">
                            <div class="px-4 py-6 sm:p-8">
                                <div class="grid max-w-2xl grid-cols-1 gap-x-6 gap-y-8 sm:grid-cols-6">
                                    <div class="sm:col-span-3">
                                        <label for="type" class="block text-sm font-medium leading-6 text-gray-900">Schedule Type</label>
                                        <div class="mt-2">
                                            <select name="type" id="type" required class="block w-full rounded-md border-0 bg-white px-3 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm">
                                                <option value="DrivingLessonSchedule" ${schedule.scheduleType == 'Driving Lesson' ? 'selected' : ''}>Driving Lesson</option>
                                                <option value="TheoryLessonSchedule" ${schedule.scheduleType == 'Theory Lesson' ? 'selected' : ''}>Theory Lesson</option>
                                                <option value="ExamSchedule" ${schedule.scheduleType == 'Exam' ? 'selected' : ''}>Exam</option>
                                            </select>
                                        </div>
                                    </div>

                                    <div class="sm:col-span-3">
                                        <label for="dateTime" class="block text-sm font-medium leading-6 text-gray-900">Date/Time</label>
                                        <div class="mt-2">
                                            <input type="datetime-local" name="dateTime" id="dateTime" value="${schedule.dateTime}" required class="block w-full rounded-md border-0 bg-white px-3 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm">
                                        </div>
                                    </div>

                                    <div class="sm:col-span-3">
                                        <label for="duration" class="block text-sm font-medium leading-6 text-gray-900">Duration (minutes)</label>
                                        <div class="mt-2">
                                            <input type="number" name="duration" id="duration" value="${schedule.duration}" required class="block w-full rounded-md border-0 bg-white px-3 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm">
                                        </div>
                                    </div>

                                    <div class="sm:col-span-3">
                                        <label for="status" class="block text-sm font-medium leading-6 text-gray-900">Status</label>
                                        <div class="mt-2">
                                            <select name="status" id="status" required class="block w-full rounded-md border-0 bg-white px-3 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm">
                                                <option value="scheduled" ${schedule.status == 'scheduled' ? 'selected' : ''}>Scheduled</option>
                                                <option value="completed" ${schedule.status == 'completed' ? 'selected' : ''}>Completed</option>
                                                <option value="cancelled" ${schedule.status == 'cancelled' ? 'selected' : ''}>Cancelled</option>
                                            </select>
                                        </div>
                                    </div>

                                    <div class="sm:col-span-3">
                                        <label for="studentId" class="block text-sm font-medium leading-6 text-gray-900">Student</label>
                                        <div class="mt-2">
                                            <select name="studentId" id="studentId" required class="block w-full rounded-md border-0 bg-white px-3 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm">
                                                <c:forEach var="student" items="${students}">
                                                    <option value="${student.id}" ${schedule.studentId == student.id ? 'selected' : ''}>${student.name}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                    </div>

                                    <div class="sm:col-span-3">
                                        <label for="instructorId" class="block text-sm font-medium leading-6 text-gray-900">Instructor</label>
                                        <div class="mt-2">
                                            <select name="instructorId" id="instructorId" required class="block w-full rounded-md border-0 bg-white px-3 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm">
                                                <c:forEach var="instructor" items="${instructors}">
                                                    <option value="${instructor.id}" ${schedule.instructorId == instructor.id ? 'selected' : ''}>${instructor.name}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                    </div>

                                    <div class="sm:col-span-3">
                                        <label for="vehicleId" class="block text-sm font-medium leading-6 text-gray-900">Vehicle</label>
                                        <div class="mt-2">
                                            <select name="vehicleId" id="vehicleId" required class="block w-full rounded-md border-0 bg-white px-3 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm">
                                                <c:forEach var="vehicle" items="${vehicles}">
                                                    <option value="${vehicle.id}" ${schedule.vehicleId == vehicle.id ? 'selected' : ''}>${vehicle.model}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="flex items-center justify-end gap-x-6 border-t border-gray-900/10 px-4 py-4 sm:px-8">
                                <a href="/schedules" class="text-sm font-semibold leading-6 text-gray-900">Cancel</a>
                                <button type="submit" class="rounded-md bg-indigo-600 px-3 py-2 text-sm font-semibold text-white shadow-sm hover:bg-indigo-500 focus-visible:outline-2 focus-visible:outline-offset-2 focus-visible:outline-indigo-600">Save Changes</button>
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