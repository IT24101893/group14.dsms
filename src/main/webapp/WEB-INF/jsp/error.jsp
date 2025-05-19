<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body>
<div id="app">
    <div class="h-full bg-gray-100">
        <div class="relative bg-gray-900">
            <header class="relative z-10">
                <nav class="bg-white shadow">
                    <div class="mx-auto max-w-7xl px-4 sm:px-6 lg:px-8">
                        <div class="flex h-16">
                            <div class="flex">
                                <a href="/" class="flex flex-shrink-0 items-center">
                                    <img class="h-12 w-auto" src="/images/logo.png" alt="Logo">
                                </a>
                            </div>
                        </div>
                    </div>
                </nav>
            </header>
        </div>

        <main class="mx-auto max-w-7xl px-4 sm:px-6 lg:px-8">
            <div class="flex min-h-[80vh] flex-col justify-center items-center py-16 sm:py-24">
                <p class="text-base font-semibold text-indigo-600">Status: ${status}</p>
                <h1 class="mt-2 text-4xl font-bold tracking-tight text-gray-900 sm:text-5xl">An error occurred</h1>
                <p class="mt-4 text-base text-gray-500">${message}</p>
                <div class="mt-10">
                    <a href="/" class="text-sm font-semibold text-indigo-600 hover:text-indigo-500">
                        Go back home
                        <span aria-hidden="true"> &rarr;</span>
                    </a>
                </div>
            </div>
        </main>
    </div>
</div>
</body>
</html>