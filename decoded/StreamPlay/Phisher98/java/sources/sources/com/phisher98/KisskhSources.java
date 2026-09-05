package com.phisher98;

import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: StreamPlayParser.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/StreamPlay/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\u0018\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0018\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J=\u0010\u0010\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\u0018\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\bHÆ\u0001J\u0014\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0014\u001a\u00020\u0015HÖ\u0081\u0004J\n\u0010\u0016\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/phisher98/KisskhSources;", "", "video", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "Video", "thirdParty", "ThirdParty", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getVideo", "()Ljava/lang/String;", "getThirdParty", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class KisskhSources {

    @Nullable
    private final String thirdParty;

    @Nullable
    private final String video;

    public static /* synthetic */ KisskhSources copy$default(KisskhSources kisskhSources, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = kisskhSources.video;
        }
        if ((i & 2) != 0) {
            str2 = kisskhSources.thirdParty;
        }
        return kisskhSources.copy(str, str2);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getVideo() {
        return this.video;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getThirdParty() {
        return this.thirdParty;
    }

    @NotNull
    public final KisskhSources copy(@JsonProperty("Video") @Nullable String video, @JsonProperty("ThirdParty") @Nullable String thirdParty) {
        return new KisskhSources(video, thirdParty);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof KisskhSources)) {
            return false;
        }
        KisskhSources kisskhSources = (KisskhSources) other;
        return Intrinsics.areEqual(this.video, kisskhSources.video) && Intrinsics.areEqual(this.thirdParty, kisskhSources.thirdParty);
    }

    public int hashCode() {
        return ((this.video == null ? 0 : this.video.hashCode()) * 31) + (this.thirdParty != null ? this.thirdParty.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "KisskhSources(video=" + this.video + ", thirdParty=" + this.thirdParty + ')';
    }

    public KisskhSources(@JsonProperty("Video") @Nullable String video, @JsonProperty("ThirdParty") @Nullable String thirdParty) {
        this.video = video;
        this.thirdParty = thirdParty;
    }

    @Nullable
    public final String getVideo() {
        return this.video;
    }

    @Nullable
    public final String getThirdParty() {
        return this.thirdParty;
    }
}
