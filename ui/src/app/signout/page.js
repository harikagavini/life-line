"use client";

import { redirect } from 'next/navigation';
import Cookies from 'js-cookie';

export default function SignOut() {
    Cookies.remove('token');
    Cookies.remove('type');
    Cookies.remove('branchId');
    Cookies.remove('hospitalId');
    redirect('/login');
}
