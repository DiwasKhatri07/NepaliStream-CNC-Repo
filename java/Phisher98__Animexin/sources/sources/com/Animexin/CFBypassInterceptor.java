package com.Animexin;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Animexin.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/Animexin/classes.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Lcom/Animexin/CFBypassInterceptor;", "Lokhttp3/Interceptor;", "<init>", "()V", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "Animexin"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nAnimexin.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Animexin.kt\ncom/Animexin/CFBypassInterceptor\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,223:1\n1739#2:224\n1814#2,3:225\n777#2:228\n873#2,2:229\n1739#2:231\n1814#2,3:232\n777#2:235\n873#2,2:236\n*S KotlinDebug\n*F\n+ 1 Animexin.kt\ncom/Animexin/CFBypassInterceptor\n*L\n36#1:224\n36#1:225,3\n37#1:228\n37#1:229,2\n38#1:231\n38#1:232,3\n38#1:235\n38#1:236,2\n*E\n"})
public final class CFBypassInterceptor implements Interceptor {

    @NotNull
    public static final CFBypassInterceptor INSTANCE = new CFBypassInterceptor();

    private CFBypassInterceptor() {
    }

    /* JADX WARN: Code duplicated, block: B:34:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:56:0x00f3 A[SYNTHETIC] */
    @NotNull
    public Response intercept(@NotNull Interceptor.Chain chain) {
        Request original;
        String savedUa;
        String savedCookies;
        boolean z;
        Request original2 = chain.request();
        Request.Builder builder = original2.newBuilder().removeHeader("X-Requested-With").header("sec-ch-ua-mobile", "?1").header("sec-ch-ua-platform", "\"Android\"");
        String savedUa2 = AnimexinPlugin.INSTANCE.getCfUserAgent();
        if (savedUa2.length() > 0) {
            builder.header("User-Agent", savedUa2);
        }
        String savedCookies2 = AnimexinPlugin.INSTANCE.getCfCookies();
        if (savedCookies2.length() > 0) {
            String existingCookie = original2.header("Cookie");
            if (existingCookie == null) {
                existingCookie = "";
            }
            Iterable $this$map$iv = StringsKt.split$default(existingCookie, new String[]{";"}, false, 0, 6, (Object) null);
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            for (Object item$iv$iv : $this$map$iv) {
                String it = (String) item$iv$iv;
                destination$iv$iv.add(StringsKt.trim(it).toString());
            }
            Iterable $this$filter$iv = (List) destination$iv$iv;
            Collection destination$iv$iv2 = new ArrayList();
            for (Object element$iv$iv : $this$filter$iv) {
                String it2 = (String) element$iv$iv;
                if (it2.length() > 0) {
                    original = original2;
                    savedUa = savedUa2;
                    savedCookies = savedCookies2;
                    z = StringsKt.startsWith$default(it2, "cf_clearance=", false, 2, (Object) null) ? false : true;
                    if (z) {
                        destination$iv$iv2.add(element$iv$iv);
                    }
                    original2 = original;
                    savedUa2 = savedUa;
                    savedCookies2 = savedCookies;
                } else {
                    original = original2;
                    savedUa = savedUa2;
                    savedCookies = savedCookies2;
                }
                if (z) {
                    destination$iv$iv2.add(element$iv$iv);
                }
                original2 = original;
                savedUa2 = savedUa;
                savedCookies2 = savedCookies;
            }
            List base = (List) destination$iv$iv2;
            Iterable $this$map$iv2 = StringsKt.split$default(savedCookies2, new String[]{";"}, false, 0, 6, (Object) null);
            Collection destination$iv$iv3 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
            for (Object item$iv$iv2 : $this$map$iv2) {
                String it3 = (String) item$iv$iv2;
                destination$iv$iv3.add(StringsKt.trim(it3).toString());
            }
            Iterable $this$filter$iv2 = (List) destination$iv$iv3;
            Collection destination$iv$iv4 = new ArrayList();
            for (Object element$iv$iv2 : $this$filter$iv2) {
                String it4 = (String) element$iv$iv2;
                if (it4.length() > 0) {
                    destination$iv$iv4.add(element$iv$iv2);
                }
            }
            List fresh = (List) destination$iv$iv4;
            builder.header("Cookie", CollectionsKt.joinToString$default(CollectionsKt.distinct(CollectionsKt.plus(base, fresh)), "; ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null));
        }
        return chain.proceed(builder.build());
    }
}
