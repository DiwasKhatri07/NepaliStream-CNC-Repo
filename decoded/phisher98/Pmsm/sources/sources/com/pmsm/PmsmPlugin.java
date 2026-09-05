package com.pmsm;

import android.content.Context;
import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.plugins.CloudstreamPlugin;
import com.lagradost.cloudstream3.plugins.Plugin;
import com.lagradost.cloudstream3.utils.ExtractorApi;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import com.lagradost.nicehttp.ResponseParser;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import okhttp3.Interceptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: PmsmPlugin.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/Pmsm/classes.dex */
@CloudstreamPlugin
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\b\u0007\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016Ê\u0001\u0002\b\n¨\u0006\t"}, d2 = {"Lcom/pmsm/PmsmPlugin;", "Lcom/lagradost/cloudstream3/plugins/Plugin;", "<init>", "()V", "load", "", "context", "Landroid/content/Context;", "Companion", "Pmsm", "Lcom/lagradost/cloudstream3/plugins/CloudstreamPlugin;"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class PmsmPlugin extends Plugin {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String DOMAINS_URL = "https://raw.githubusercontent.com/phisher98/TVVVV/refs/heads/main/domains.json";

    @Nullable
    private static Companion.Domains cachedDomains;

    public void load(@NotNull Context context) {
        registerMainAPI(new Pmsm());
        registerExtractorAPI((ExtractorApi) new DhtprePmsm());
        registerExtractorAPI((ExtractorApi) new NetuPmsm());
        registerExtractorAPI((ExtractorApi) new Playerxupns());
        registerExtractorAPI((ExtractorApi) new Playerxp2p());
        registerExtractorAPI((ExtractorApi) new Playerxseek());
        registerExtractorAPI((ExtractorApi) new Playerxrpms());
        registerExtractorAPI((ExtractorApi) new Player4me());
        registerExtractorAPI((ExtractorApi) new Ezplayer());
        registerExtractorAPI((ExtractorApi) new YandexcdnPmsm());
        registerExtractorAPI(new Larhu());
    }

    /* JADX INFO: compiled from: PmsmPlugin.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\u0010B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\f\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0086@¢\u0006\u0002\u0010\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u0011"}, d2 = {"Lcom/pmsm/PmsmPlugin$Companion;", "", "<init>", "()V", "DOMAINS_URL", "", "cachedDomains", "Lcom/pmsm/PmsmPlugin$Companion$Domains;", "getCachedDomains", "()Lcom/pmsm/PmsmPlugin$Companion$Domains;", "setCachedDomains", "(Lcom/pmsm/PmsmPlugin$Companion$Domains;)V", "getDomains", "forceRefresh", "", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Domains", "Pmsm"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nPmsmPlugin.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PmsmPlugin.kt\ncom/pmsm/PmsmPlugin$Companion\n+ 2 NiceResponse.kt\ncom/lagradost/nicehttp/NiceResponse\n*L\n1#1,46:1\n73#2,5:47\n*S KotlinDebug\n*F\n+ 1 PmsmPlugin.kt\ncom/pmsm/PmsmPlugin$Companion\n*L\n32#1:47,5\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @Nullable
        public final Domains getCachedDomains() {
            return PmsmPlugin.cachedDomains;
        }

        public final void setCachedDomains(@Nullable Domains domains) {
            PmsmPlugin.cachedDomains = domains;
        }

        public static /* synthetic */ Object getDomains$default(Companion companion, boolean z, Continuation continuation, int i, Object obj) {
            if ((i & 1) != 0) {
                z = false;
            }
            return companion.getDomains(z, continuation);
        }

        /* JADX WARN: Code duplicated, block: B:7:0x001a  */
        @Nullable
        public final Object getDomains(boolean forceRefresh, @NotNull Continuation<? super Domains> continuation) {
            PmsmPlugin$Companion$getDomains$1 pmsmPlugin$Companion$getDomains$1;
            Companion companion;
            Object safe;
            if (continuation instanceof PmsmPlugin$Companion$getDomains$1) {
                pmsmPlugin$Companion$getDomains$1 = (PmsmPlugin$Companion$getDomains$1) continuation;
                if ((pmsmPlugin$Companion$getDomains$1.label & Integer.MIN_VALUE) != 0) {
                    pmsmPlugin$Companion$getDomains$1.label -= Integer.MIN_VALUE;
                } else {
                    pmsmPlugin$Companion$getDomains$1 = new PmsmPlugin$Companion$getDomains$1(this, continuation);
                }
            } else {
                pmsmPlugin$Companion$getDomains$1 = new PmsmPlugin$Companion$getDomains$1(this, continuation);
            }
            PmsmPlugin$Companion$getDomains$1 pmsmPlugin$Companion$getDomains$2 = pmsmPlugin$Companion$getDomains$1;
            Object $result = pmsmPlugin$Companion$getDomains$2.result;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (pmsmPlugin$Companion$getDomains$2.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    if (getCachedDomains() == null || forceRefresh) {
                        try {
                            Requests app = MainActivityKt.getApp();
                            try {
                                pmsmPlugin$Companion$getDomains$2.L$0 = this;
                                pmsmPlugin$Companion$getDomains$2.Z$0 = forceRefresh;
                                pmsmPlugin$Companion$getDomains$2.label = 1;
                                try {
                                    $result = Requests.get$default(app, PmsmPlugin.DOMAINS_URL, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, pmsmPlugin$Companion$getDomains$2, 4094, (Object) null);
                                    if ($result == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    companion = this;
                                    try {
                                        NiceResponse this_$iv = (NiceResponse) $result;
                                        try {
                                            ResponseParser parser = this_$iv.getParser();
                                            Intrinsics.checkNotNull(parser);
                                            safe = parser.parseSafe(this_$iv.getText(), Reflection.getOrCreateKotlinClass(Domains.class));
                                        } catch (Exception e$iv) {
                                            e$iv.printStackTrace();
                                            safe = null;
                                        }
                                        companion.setCachedDomains((Domains) safe);
                                    } catch (Exception e) {
                                        e = e;
                                        e.printStackTrace();
                                        return null;
                                    }
                                } catch (Exception e2) {
                                    e = e2;
                                    e.printStackTrace();
                                    return null;
                                }
                            } catch (Exception e3) {
                                e = e3;
                            }
                        } catch (Exception e4) {
                            e = e4;
                        }
                        break;
                    }
                    return getCachedDomains();
                case 1:
                    boolean z = pmsmPlugin$Companion$getDomains$2.Z$0;
                    Companion companion2 = (Companion) pmsmPlugin$Companion$getDomains$2.L$0;
                    try {
                        ResultKt.throwOnFailure($result);
                        companion = companion2;
                        NiceResponse this_$iv2 = (NiceResponse) $result;
                        ResponseParser parser2 = this_$iv2.getParser();
                        Intrinsics.checkNotNull(parser2);
                        safe = parser2.parseSafe(this_$iv2.getText(), Reflection.getOrCreateKotlinClass(Domains.class));
                        companion.setCachedDomains((Domains) safe);
                        return getCachedDomains();
                    } catch (Exception e5) {
                        e = e5;
                        e.printStackTrace();
                        return null;
                    }
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: compiled from: PmsmPlugin.kt */
        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\r\u001a\u00020\u000eHÖ\u0081\u0004J\n\u0010\u000f\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/pmsm/PmsmPlugin$Companion$Domains;", "", "pencurimoviesubmalay", "", "<init>", "(Ljava/lang/String;)V", "getPencurimoviesubmalay", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "Pmsm"}, k = 1, mv = {2, 4, 0}, xi = 48)
        public static final /* data */ class Domains {

            @NotNull
            private final String pencurimoviesubmalay;

            public static /* synthetic */ Domains copy$default(Domains domains, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = domains.pencurimoviesubmalay;
                }
                return domains.copy(str);
            }

            @NotNull
            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getPencurimoviesubmalay() {
                return this.pencurimoviesubmalay;
            }

            @NotNull
            public final Domains copy(@NotNull String pencurimoviesubmalay) {
                return new Domains(pencurimoviesubmalay);
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Domains) && Intrinsics.areEqual(this.pencurimoviesubmalay, ((Domains) other).pencurimoviesubmalay);
            }

            public int hashCode() {
                return this.pencurimoviesubmalay.hashCode();
            }

            @NotNull
            public String toString() {
                return "Domains(pencurimoviesubmalay=" + this.pencurimoviesubmalay + ')';
            }

            public Domains(@NotNull String pencurimoviesubmalay) {
                this.pencurimoviesubmalay = pencurimoviesubmalay;
            }

            @NotNull
            public final String getPencurimoviesubmalay() {
                return this.pencurimoviesubmalay;
            }
        }
    }
}
