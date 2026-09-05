package com.Kartoons;

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

/* JADX INFO: compiled from: Kartoons.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/Kartoons/classes.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Lcom/Kartoons/KartoonsCFBypassInterceptor;", "Lokhttp3/Interceptor;", "<init>", "()V", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "Kartoons"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nKartoons.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Kartoons.kt\ncom/Kartoons/KartoonsCFBypassInterceptor\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,527:1\n1739#2:528\n1814#2,3:529\n777#2:532\n873#2,2:533\n1739#2:535\n1814#2,3:536\n777#2:539\n873#2,2:540\n*S KotlinDebug\n*F\n+ 1 Kartoons.kt\ncom/Kartoons/KartoonsCFBypassInterceptor\n*L\n58#1:528\n58#1:529,3\n58#1:532\n58#1:533,2\n59#1:535\n59#1:536,3\n59#1:539\n59#1:540,2\n*E\n"})
public final class KartoonsCFBypassInterceptor implements Interceptor {

    @NotNull
    public static final KartoonsCFBypassInterceptor INSTANCE = new KartoonsCFBypassInterceptor();

    private KartoonsCFBypassInterceptor() {
    }

    @NotNull
    public Response intercept(@NotNull Interceptor.Chain chain) {
        Request original = chain.request();
        Request.Builder builder = original.newBuilder();
        String savedUa = KartoonsPlugin.INSTANCE.getCfUserAgent();
        if (savedUa.length() > 0) {
            builder.header("User-Agent", savedUa);
        }
        String savedCookies = KartoonsPlugin.INSTANCE.getCfCookies();
        if (savedCookies.length() > 0) {
            String existingCookie = original.header("Cookie");
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
                    destination$iv$iv2.add(element$iv$iv);
                }
            }
            List base = (List) destination$iv$iv2;
            Iterable $this$map$iv2 = StringsKt.split$default(savedCookies, new String[]{";"}, false, 0, 6, (Object) null);
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
