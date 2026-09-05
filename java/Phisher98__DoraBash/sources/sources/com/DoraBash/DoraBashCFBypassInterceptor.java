package com.DoraBash;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
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

/* JADX INFO: compiled from: DoraBash.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/DoraBash/classes.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Lcom/DoraBash/DoraBashCFBypassInterceptor;", "Lokhttp3/Interceptor;", "<init>", "()V", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "DoraBash"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nDoraBash.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DoraBash.kt\ncom/DoraBash/DoraBashCFBypassInterceptor\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,342:1\n1739#2:343\n1814#2,3:344\n777#2:347\n873#2,2:348\n1739#2:350\n1814#2,3:351\n777#2:354\n873#2,2:355\n1739#2:358\n1814#2,3:359\n777#2:362\n873#2,2:363\n1#3:357\n*S KotlinDebug\n*F\n+ 1 DoraBash.kt\ncom/DoraBash/DoraBashCFBypassInterceptor\n*L\n39#1:343\n39#1:344,3\n40#1:347\n40#1:348,2\n41#1:350\n41#1:351,3\n41#1:354\n41#1:355,2\n54#1:358\n54#1:359,3\n54#1:362\n54#1:363,2\n*E\n"})
public final class DoraBashCFBypassInterceptor implements Interceptor {

    @NotNull
    public static final DoraBashCFBypassInterceptor INSTANCE = new DoraBashCFBypassInterceptor();

    private DoraBashCFBypassInterceptor() {
    }

    /* JADX WARN: Code duplicated, block: B:106:0x02d2 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:35:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:83:0x02cf  */
    /* JADX WARN: Code duplicated, block: B:93:0x00fa A[SYNTHETIC] */
    @NotNull
    public Response intercept(@NotNull Interceptor.Chain chain) {
        Object next;
        Iterable $this$filter$iv;
        Request.Builder builder;
        boolean z;
        Request original;
        String savedUa;
        String savedCookies;
        boolean z2;
        Request original2 = chain.request();
        Request.Builder builder2 = original2.newBuilder().removeHeader("X-Requested-With").header("sec-ch-ua-mobile", "?1").header("sec-ch-ua-platform", "\"Android\"");
        String savedUa2 = DoraBashProvider.INSTANCE.getCfUserAgent();
        if (savedUa2.length() > 0) {
            builder2.header("User-Agent", savedUa2);
        }
        String savedCookies2 = DoraBashProvider.INSTANCE.getCfCookies();
        if (savedCookies2.length() > 0) {
            String existingCookie = original2.header("Cookie");
            if (existingCookie == null) {
                existingCookie = "";
            }
            Iterable $this$map$iv = StringsKt.split$default(existingCookie, new String[]{";"}, false, 0, 6, (Object) null);
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            for (Object item$iv$iv : $this$map$iv) {
                destination$iv$iv.add(StringsKt.trim((String) item$iv$iv).toString());
            }
            Collection destination$iv$iv2 = new ArrayList();
            for (Object element$iv$iv : (List) destination$iv$iv) {
                String it = (String) element$iv$iv;
                if (it.length() > 0) {
                    original = original2;
                    savedUa = savedUa2;
                    savedCookies = savedCookies2;
                    z2 = StringsKt.startsWith$default(it, "cf_clearance=", false, 2, (Object) null) ? false : true;
                    if (z2) {
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
                if (z2) {
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
                destination$iv$iv3.add(StringsKt.trim((String) item$iv$iv2).toString());
                base = base;
            }
            List base2 = base;
            Collection destination$iv$iv4 = new ArrayList();
            for (Object element$iv$iv2 : (List) destination$iv$iv3) {
                if (((String) element$iv$iv2).length() > 0) {
                    destination$iv$iv4.add(element$iv$iv2);
                }
            }
            List fresh = (List) destination$iv$iv4;
            builder2.header("Cookie", CollectionsKt.joinToString$default(CollectionsKt.distinct(CollectionsKt.plus(fresh, base2)), "; ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null));
        }
        Response response = chain.proceed(builder2.build());
        List setCookie = response.headers("Set-Cookie");
        if (setCookie.isEmpty()) {
            return response;
        }
        Iterator it2 = setCookie.iterator();
        do {
            if (!it2.hasNext()) {
                next = null;
                break;
            }
            next = it2.next();
        } while (!StringsKt.contains$default((String) next, "cf_clearance=", false, 2, (Object) null));
        String cfClearance = (String) next;
        if (cfClearance == null) {
            return response;
        }
        String token = StringsKt.trim(StringsKt.substringBefore$default(cfClearance, ";", (String) null, 2, (Object) null)).toString();
        String existing = DoraBashProvider.INSTANCE.getCfCookies();
        if (StringsKt.contains$default(existing, token, false, 2, (Object) null)) {
            return response;
        }
        Iterable $this$map$iv3 = StringsKt.split$default(existing, new String[]{";"}, false, 0, 6, (Object) null);
        Collection destination$iv$iv5 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv3, 10));
        for (Object item$iv$iv3 : $this$map$iv3) {
            destination$iv$iv5.add(StringsKt.trim((String) item$iv$iv3).toString());
            response = response;
        }
        Response response2 = response;
        Iterable $this$filter$iv2 = (List) destination$iv$iv5;
        Collection destination$iv$iv6 = new ArrayList();
        for (Object element$iv$iv3 : $this$filter$iv2) {
            String it3 = (String) element$iv$iv3;
            if (it3.length() > 0) {
                $this$filter$iv = $this$filter$iv2;
                builder = builder2;
                z = StringsKt.startsWith$default(it3, "cf_clearance=", false, 2, (Object) null) ? false : true;
                if (z) {
                    destination$iv$iv6.add(element$iv$iv3);
                }
                builder2 = builder;
                $this$filter$iv2 = $this$filter$iv;
            } else {
                $this$filter$iv = $this$filter$iv2;
                builder = builder2;
            }
            if (z) {
                destination$iv$iv6.add(element$iv$iv3);
            }
            builder2 = builder;
            $this$filter$iv2 = $this$filter$iv;
        }
        List base3 = (List) destination$iv$iv6;
        DoraBashProvider.INSTANCE.setCfCookies(CollectionsKt.joinToString$default(CollectionsKt.plus(CollectionsKt.listOf(token), base3), "; ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null));
        return response2;
    }
}
