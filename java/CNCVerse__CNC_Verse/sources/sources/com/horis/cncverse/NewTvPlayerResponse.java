package com.horis.cncverse;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Utils.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/cncverse/CNC_Verse/classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004J\n\u0010\u0015\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/horis/cncverse/NewTvPlayerResponse;", "", "status", "", "video_link", "referer", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getStatus", "()Ljava/lang/String;", "getVideo_link", "getReferer", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "CNC Verse_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class NewTvPlayerResponse {

    @Nullable
    private final String referer;

    @Nullable
    private final String status;

    @Nullable
    private final String video_link;

    public NewTvPlayerResponse() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ NewTvPlayerResponse copy$default(NewTvPlayerResponse newTvPlayerResponse, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = newTvPlayerResponse.status;
        }
        if ((i & 2) != 0) {
            str2 = newTvPlayerResponse.video_link;
        }
        if ((i & 4) != 0) {
            str3 = newTvPlayerResponse.referer;
        }
        return newTvPlayerResponse.copy(str, str2, str3);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getVideo_link() {
        return this.video_link;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getReferer() {
        return this.referer;
    }

    @NotNull
    public final NewTvPlayerResponse copy(@Nullable String status, @Nullable String video_link, @Nullable String referer) {
        return new NewTvPlayerResponse(status, video_link, referer);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NewTvPlayerResponse)) {
            return false;
        }
        NewTvPlayerResponse newTvPlayerResponse = (NewTvPlayerResponse) other;
        return Intrinsics.areEqual(this.status, newTvPlayerResponse.status) && Intrinsics.areEqual(this.video_link, newTvPlayerResponse.video_link) && Intrinsics.areEqual(this.referer, newTvPlayerResponse.referer);
    }

    public int hashCode() {
        return ((((this.status == null ? 0 : this.status.hashCode()) * 31) + (this.video_link == null ? 0 : this.video_link.hashCode())) * 31) + (this.referer != null ? this.referer.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "NewTvPlayerResponse(status=" + this.status + ", video_link=" + this.video_link + ", referer=" + this.referer + ')';
    }

    public NewTvPlayerResponse(@Nullable String status, @Nullable String video_link, @Nullable String referer) {
        this.status = status;
        this.video_link = video_link;
        this.referer = referer;
    }

    public /* synthetic */ NewTvPlayerResponse(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3);
    }

    @Nullable
    public final String getStatus() {
        return this.status;
    }

    @Nullable
    public final String getVideo_link() {
        return this.video_link;
    }

    @Nullable
    public final String getReferer() {
        return this.referer;
    }
}
