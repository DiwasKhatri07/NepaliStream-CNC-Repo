package com.phisher98;

import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import com.lagradost.nicehttp.ResponseParser;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import okhttp3.Interceptor;

/* JADX INFO: compiled from: StremioC.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/StremioX/classes.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "", "Lcom/phisher98/StremioC$CatalogEntry;", "type", ""}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.phisher98.StremioC$Catalog$toHomePageList$allMetas$1", f = "StremioC.kt", i = {0, 0, 0}, l = {380}, m = "invokeSuspend", n = {"type", "path", "url"}, nl = {1059}, s = {"L$0", "L$1", "L$2"}, v = 2)
@SourceDebugExtension({"SMAP\nStremioC.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StremioC.kt\ncom/phisher98/StremioC$Catalog$toHomePageList$allMetas$1\n+ 2 NiceResponse.kt\ncom/lagradost/nicehttp/NiceResponse\n*L\n1#1,1058:1\n73#2,5:1059\n*S KotlinDebug\n*F\n+ 1 StremioC.kt\ncom/phisher98/StremioC$Catalog$toHomePageList$allMetas$1\n*L\n380#1:1059,5\n*E\n"})
final class StremioC$Catalog$toHomePageList$allMetas$1 extends SuspendLambda implements Function2<String, Continuation<? super List<? extends StremioC.CatalogEntry>>, Object> {
    final /* synthetic */ StremioC $provider;
    final /* synthetic */ int $skip;
    /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ StremioC.Catalog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StremioC$Catalog$toHomePageList$allMetas$1(int i, StremioC.Catalog catalog, StremioC stremioC, Continuation<? super StremioC$Catalog$toHomePageList$allMetas$1> continuation) {
        super(2, continuation);
        this.$skip = i;
        this.this$0 = catalog;
        this.$provider = stremioC;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> stremioC$Catalog$toHomePageList$allMetas$1 = new StremioC$Catalog$toHomePageList$allMetas$1(this.$skip, this.this$0, this.$provider, continuation);
        stremioC$Catalog$toHomePageList$allMetas$1.L$0 = obj;
        return stremioC$Catalog$toHomePageList$allMetas$1;
    }

    public final Object invoke(String str, Continuation<? super List<StremioC.CatalogEntry>> continuation) {
        return create(str, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        String path;
        Object obj;
        Object safe;
        List<StremioC.CatalogEntry> metas;
        String type = (String) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (this.$skip > 0) {
                    path = "/catalog/" + type + '/' + this.this$0.getId() + "/skip=" + this.$skip + ".json";
                } else {
                    path = "/catalog/" + type + '/' + this.this$0.getId() + ".json";
                }
                String url = this.$provider.buildUrl(path);
                this.L$0 = SpillingKt.nullOutSpilledVariable(type);
                this.L$1 = SpillingKt.nullOutSpilledVariable(path);
                this.L$2 = SpillingKt.nullOutSpilledVariable(url);
                this.label = 1;
                obj = Requests.get$default(MainActivityKt.getApp(), url, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 120L, (Interceptor) null, false, (ResponseParser) null, (Continuation) this, 3838, (Object) null);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                obj = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        NiceResponse this_$iv = (NiceResponse) obj;
        try {
            ResponseParser parser = this_$iv.getParser();
            Intrinsics.checkNotNull(parser);
            safe = parser.parseSafe(this_$iv.getText(), Reflection.getOrCreateKotlinClass(StremioC.CatalogResponse.class));
        } catch (Exception e$iv) {
            e$iv.printStackTrace();
            safe = null;
        }
        StremioC.CatalogResponse res = (StremioC.CatalogResponse) safe;
        return (res == null || (metas = res.getMetas()) == null) ? CollectionsKt.emptyList() : metas;
    }
}
