import { redirect } from 'next/navigation';
import Cookies from 'js-cookie';

export default function SignOut() {
    Cookies.remove('token');
    redirect('/login');
}