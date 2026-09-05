package com.Cinemacity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Cinemacity.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/Cinemacity/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Lcom/Cinemacity/CinemacityCFBypassInterceptor;", "Lokhttp3/Interceptor;", "<init>", "()V", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "Cinemacity"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nCinemacity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Cinemacity.kt\ncom/Cinemacity/CinemacityCFBypassInterceptor\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,844:1\n1739#2:845\n1814#2,3:846\n777#2:849\n873#2,2:850\n1739#2:852\n1814#2,3:853\n777#2:856\n873#2,2:857\n*S KotlinDebug\n*F\n+ 1 Cinemacity.kt\ncom/Cinemacity/CinemacityCFBypassInterceptor\n*L\n74#1:845\n74#1:846,3\n75#1:849\n75#1:850,2\n76#1:852\n76#1:853,3\n76#1:856\n76#1:857,2\n*E\n"})
public final class CinemacityCFBypassInterceptor implements Interceptor {

    @NotNull
    public static final CinemacityCFBypassInterceptor INSTANCE = new CinemacityCFBypassInterceptor();

    private CinemacityCFBypassInterceptor() {
    }

    /* JADX WARN: Code duplicated, block: B:37:0x00f9  */
    /* JADX WARN: Code duplicated, block: B:59:0x00fc A[SYNTHETIC] */
    @NotNull
    public Response intercept(@NotNull Interceptor.Chain chain) {
        Request original;
        String savedUa;
        String savedCookies;
        boolean z;
        Request original2 = chain.request();
        Request.Builder builder = original2.newBuilder();
        if (!Intrinsics.areEqual(original2.header("X-Requested-With"), "XMLHttpRequest")) {
            builder.removeHeader("X-Requested-With");
        }
        builder.header("sec-ch-ua-mobile", "?1").header("sec-ch-ua-platform", "\"Android\"");
        String savedUa2 = CinemacityPlugin.INSTANCE.getCfUserAgent();
        if (savedUa2.length() > 0) {
            builder.header("User-Agent", savedUa2);
        }
        String savedCookies2 = CinemacityPlugin.INSTANCE.getCfCookies();
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
            builder.header("Cookie", CollectionsKt.joinToString$default(CollectionsKt.distinct(CollectionsKt.plus(fresh, base)), "; ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null));
        }
        return chain.proceed(builder.build());
    }
}
